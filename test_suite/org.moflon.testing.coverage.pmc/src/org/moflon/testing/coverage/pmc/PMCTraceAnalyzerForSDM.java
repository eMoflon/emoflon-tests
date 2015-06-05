package org.moflon.testing.coverage.pmc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.moflon.tracing.sdm.StackTraceWrapper;
import org.moflon.tracing.sdm.events.AbstractBindingEvent;
import org.moflon.tracing.sdm.events.AbstractMatchEvent;
import org.moflon.tracing.sdm.events.BindObjectVarEvent;
import org.moflon.tracing.sdm.events.MatchFoundEvent;
import org.moflon.tracing.sdm.events.TraceEvent;

import SDMLanguage.activities.Activity;
import SDMLanguage.activities.ActivityNode;
import SDMLanguage.activities.StoryNode;
import SDMLanguage.patterns.BindingState;
import SDMLanguage.patterns.ObjectVariable;
import SDMLanguage.patterns.StoryPattern;

/**
 * This class takes the collected trace data for one single SDM operation - whereby the trace data is already separated
 * w.r.t. different invocations of the corresponding method - and further splits the traces into respective sections relevant only
 * to one single pattern within the SDM operation. In addition, the pattern evaluations can also be distinguished (e.g. pattern
 * p1 is evaluated for the first time, for the second time ... during this very operation invocation). This allows for calculation of the
 * values for the Pattern Matching Coverage (PMC) metric based on either a distinct pattern evaluation or the accumulated traces for all
 * pattern evaluations during one operation invocation. A merging of the traces of several method invocations for one pattern to calculate
 * a singe metric value seems unnatural (this might even count for the case of several pattern evaluations). 
 * 
 * @author wieber
 *
 */
public class PMCTraceAnalyzerForSDM {

	private Map<StackTraceWrapper, TraceEvent[]> operationTraces;
	private final Activity activity;
	private List<PatternTraceAbstraction> patternAndTraces = new LinkedList<PatternTraceAbstraction>(); 
	
	public PMCTraceAnalyzerForSDM(Activity activity, Map<StackTraceWrapper, TraceEvent[]> operationTraces) {
		this.activity = activity;
		this.operationTraces = new HashMap<StackTraceWrapper, TraceEvent[]>(operationTraces);
		digestTrace();
	}
	
	private void digestTrace() {
		for (ActivityNode node : activity.getOwnedActivityNode()) {
			if (node instanceof StoryNode) {
				PatternTraceAbstraction patterTrace = new PatternTraceAbstraction((StoryNode)node);
				patterTrace.fillPatternTraces(operationTraces);
				patternAndTraces.add(patterTrace);
			}
		}
	}
	
	public PatternTraceAbstraction getPatternTraceAbstraction(StoryPattern storyPattern) {
		StoryNode storyNode = storyPattern.getStoryNode();
		for (PatternTraceAbstraction pta : patternAndTraces) {
			if (pta.getStoryNode().getName().equals(storyNode.getName()))
				return pta;
		}
		return null;
	}
	
//	public Map<StackTraceWrapper, TraceEvent[]> getOperationTraces() {
//		return Collections.unmodifiableMap(operationTraces);		
//	}
//	
//	public Map<StoryNode, Map<StackTraceWrapper, List<TraceEvent[]>>> getPatternTraces() {
//		Map<StoryNode, Map<StackTraceWrapper, List<TraceEvent[]>>> result = new HashMap<StoryNode, Map<StackTraceWrapper, List<TraceEvent[]>>>();
//		for (PatternTraceAbstraction temp : patternAndTraces) {
//			result.put(temp.getStoryNode(), temp.getPatternRelevantTraces());
//		}
//		return Collections.unmodifiableMap(result);
//	}
	
	
	public Activity getActivity() {
		return activity;
	}
	
	public Object analyzeTrace() {
		internalAnalyzeTrace();
		return getResult();
	}
	
	/**
	 * Analyze the trace data 
	 */
	private void internalAnalyzeTrace() { 
		Map<StoryNode, PatternPMCInformation> pattern2pmcInfo = new HashMap<StoryNode, PatternPMCInformation>();
		
		// iterate over all patterns and the relevant traces (separated w.r.t. method invocations)
		for (PatternTraceAbstraction abstraction : patternAndTraces) {
			String patternName = abstraction.getPatternName();
			
			// collect some basic information about the pattern
			List<String> variables = abstraction.getVariables();
			boolean[] initialStateVec = new boolean[variables.size()];
			// init stateVec with already bound variables
			for (ObjectVariable obVar : abstraction.getStoryNode().getStoryPattern().getObjectVariable()) {
				if (BindingState.BOUND.equals(obVar.getBindingState())) {
					initialStateVec[getIndex(variables, obVar.getName())] = true;
				}
			}
			
			// initialize data structure that maintains only the relevant trace informations (TraceEvent[])
			// w.r.t. the method invocation (StackTraceWrapper), and the pattern evaluation (list-index)
			Map<StackTraceWrapper, List<TraceEvent[]>> patternRelevantTraces = abstraction.getPatternRelevantTraces();
			
			// iterate over full traces for each method invocation and relevant trace events
			for (StackTraceWrapper stw : patternRelevantTraces.keySet()) {
				List<TraceEvent[]> listOfTraces = patternRelevantTraces.get(stw);
				
				// create a new instance of helper class that encodes binding information in bitvectors rather than
				// in form of trace events
				PatternPMCInformation pmcInformation = new PatternPMCInformation(abstraction.getStoryNode(), variables);
				pattern2pmcInfo.put(abstraction.getStoryNode(), pmcInformation);
				
				// iterate through the traces collected for each pattern evaluation and add binding state vectors as entries
				// to the PatternPMCInformation instance
				for (int i=0; i<listOfTraces.size(); i++) {
					TraceEvent[] traceEvents = listOfTraces.get(i);
					
					pmcInformation.addInformation(stw, i, initialStateVec);
					//pmcInformation.addInformation(stw, PatternPMCInformation.COMBINED_RUNS_INDEX, initialStateVec);

					boolean[] stateVec = Arrays.copyOf(initialStateVec, initialStateVec.length);
					for (TraceEvent e : traceEvents) {
						if (e instanceof AbstractBindingEvent) {
							// bind or unbind detected
							AbstractBindingEvent bindEvent = (AbstractBindingEvent) e;
							String objVarName = (String) bindEvent.getTraceData();
							stateVec = Arrays.copyOf(stateVec, stateVec.length);
							int index = getIndex(variables, objVarName);
							// set variable referenced by objVarName to be "bound" (true) or "unbound" (false)
							stateVec[index] = (e instanceof BindObjectVarEvent);
							// write the new stateVec to the PatternPMCInformation instance
							pmcInformation.addInformation(stw, i, stateVec);
							// pmcInformation.addInformation(stw, PatternPMCInformation.COMBINED_RUNS_INDEX, stateVec);
						} else if (e instanceof AbstractMatchEvent) {
							// the pattern either matched or did not match
							AbstractMatchEvent matchEvent = (AbstractMatchEvent) e;
							String storyPatternName = (String) matchEvent.getTraceData();
							if (patternName.equals(storyPatternName)) {
								if (matchEvent instanceof MatchFoundEvent) {
									pmcInformation.setCompleteMatch(stw, i);
									// pmcInformation.setCompleteMatch(stw, PatternPMCInformation.COMBINED_RUNS_INDEX); // this does not make sense
								}
							}
						}
						// all other event types can be ignored for PMC metrics calculation
					}
				}
			}
		}
		
		// further process the data stored in pattern2pmcInfo to derive the PMC metric values
		for (PatternTraceAbstraction abstraction : patternAndTraces) {
			StoryNode pattern = abstraction.getStoryNode();
			List<String> patternVariables = abstraction.getVariables();
			List<String> unboundPatternVariables = getUnboundPatternVariables(pattern);
			PatternPMCInformation patternPMCInformation = pattern2pmcInfo.get(pattern);
			if (patternPMCInformation == null)
				throw new IllegalStateException();
			final int maxRunIndex = patternPMCInformation.getMaxRunIndex();
			for (StackTraceWrapper stw : abstraction.getPatternRelevantTraces().keySet()) {
				for (int i = 0; i <= maxRunIndex; i++) {
					List<boolean[]> bindingVector = patternPMCInformation.getBindingVector(stw, i);
					if (bindingVector == null)
						throw new IllegalStateException();
					final boolean bindEndResult = patternPMCInformation.isCompleteMatch(stw, i);
					
					// determine PMC values for single variable
					for (String var : unboundPatternVariables) {
						boolean[] sequence = PmcCovUtil.getTraceInfoSequenceForIndex(getIndex(patternVariables, var), bindingVector);
						
						final boolean pmc0 = PmcCovUtil.checkPMC0(sequence);
						final boolean pmc0_plus = pmc0 && bindEndResult;
						final boolean pmc0_minus = pmc0 && !bindEndResult;
						
						final boolean pmc1_1 = PmcCovUtil.checkPMC1(sequence, 1);
						final boolean pmc1_1_plus = pmc1_1 && bindEndResult;
						final boolean pmc1_1_minus = pmc1_1 && !bindEndResult;
						
						final boolean pmc1_2 = PmcCovUtil.checkPMC1(sequence, 2);
						final boolean pmc1_2_plus = pmc1_2 && bindEndResult;
						final boolean pmc1_2_minus = pmc1_2 && !bindEndResult;
					}
					
					// determine PMC values for pairs of variables
					for (int i1=0; i1<unboundPatternVariables.size()-1; i1++) {
						for (int i2=i1+1; i2<unboundPatternVariables.size(); i2++) {
							try {
								String var1 = unboundPatternVariables.get(i1);
								String var2 = unboundPatternVariables.get(i2);
								
								boolean[] sequence1 = PmcCovUtil.getTraceInfoSequenceForIndex(getIndex(patternVariables, var1), bindingVector);
								boolean[] sequence2 = PmcCovUtil.getTraceInfoSequenceForIndex(getIndex(patternVariables, var2), bindingVector);
								
								final boolean pmc2_1 = PmcCovUtil.checkPMC2(sequence1, sequence2, 1);
								final boolean pmc2_1_plus = pmc2_1 && bindEndResult;
								final boolean pmc2_1_minus = pmc2_1 && !bindEndResult;
								
								final boolean pmc2_2 = PmcCovUtil.checkPMC2(sequence1, sequence2, 2);
								final boolean pmc2_2_plus = pmc2_2 && bindEndResult;
								final boolean pmc2_2_minus = pmc2_2 && !bindEndResult;
								
							} catch (IndexOutOfBoundsException e) {
								// do nothing
							}
						}
					}
				}
			}
		}
	}
	
	private List<String> getUnboundPatternVariables(StoryNode pattern) {
		List<String> result = new ArrayList<String>();
		for (ObjectVariable objVar : pattern.getStoryPattern().getObjectVariable()) {
			if (objVar.getBindingState().equals(BindingState.UNBOUND)) {
				result.add(objVar.getName());
			}			
		}
		return result;
	}
	
	private int getIndex(List<String> variables, String variableName) {
		int index = -1;
		int i = -1;
		for (String tempVariableName : variables) {
			i++;
			if (variableName.equals(tempVariableName.subSequence(0, tempVariableName.indexOf(':')))) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public Object getResult() {
		return null;
	}
}
