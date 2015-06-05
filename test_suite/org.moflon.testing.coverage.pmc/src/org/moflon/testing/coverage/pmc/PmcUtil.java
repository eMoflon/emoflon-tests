package org.moflon.testing.coverage.pmc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.moflon.tracing.sdm.events.AbstractPatternControlFlowEvent;
import org.moflon.tracing.sdm.events.BindObjectVarEvent;
import org.moflon.tracing.sdm.events.CommenceOfGraphRewritingEvent;
import org.moflon.tracing.sdm.events.LightweightPatternEnterEvent;
import org.moflon.tracing.sdm.events.LightweightPatternExitEvent;
import org.moflon.tracing.sdm.events.MatchFoundEvent;
import org.moflon.tracing.sdm.events.NoMatchFoundEvent;
import org.moflon.tracing.sdm.events.PatternEnterEvent;
import org.moflon.tracing.sdm.events.PatternExitEvent;
import org.moflon.tracing.sdm.events.TraceEvent;
import org.moflon.tracing.sdm.events.UnbindObjectVarEvent;

import SDMLanguage.patterns.ObjectVariable;
import SDMLanguage.patterns.StoryPattern;

public class PmcUtil {

	public static TraceEvent[] getTraceEventsForPattern(StoryPattern sp, TraceEvent[] methodTrace) {
		final String spName = sp.getStoryNode().getName();
		
		List<TraceEvent> relevantTrace = new ArrayList<TraceEvent>();
		Stack<Boolean> stack = new Stack<Boolean>();		
		boolean active = false;		
		for (int i = 0; i < methodTrace.length; i++) {
			TraceEvent e = methodTrace[i];
			if (e instanceof PatternEnterEvent || e instanceof LightweightPatternEnterEvent) {
				String tmpPatternName = ((AbstractPatternControlFlowEvent) e).getStoryPatternName();
				if (spName.equals(tmpPatternName)) {
					stack.push(true);
					active = true;
				} else {
					stack.push(false);
					active = false;
				}					
			}
			if (active)
				relevantTrace.add(e);
			if (e instanceof PatternExitEvent || e instanceof LightweightPatternExitEvent) {
				stack.pop();
				if (!stack.isEmpty()) {
					active = stack.peek().booleanValue();
				} else {
					active = false;
				}
			}
		}
		
		return relevantTrace.toArray(new TraceEvent[0]);
	}
	
	public static List<TraceEvent[]> getPatternInvocationTraces(TraceEvent[] patternTrace) {
		List<List<TraceEvent>> relevantTraces = new ArrayList<List<TraceEvent>>();
		List<TraceEvent> relevantTrace = null;
		Stack<List<TraceEvent>> tracesStack = new Stack<List<TraceEvent>>();
		boolean active = false;
		for (int i = 0; i < patternTrace.length; i++) {
			TraceEvent e = patternTrace[i];
			if (e instanceof PatternEnterEvent || e instanceof LightweightPatternEnterEvent) {				
				relevantTrace = new ArrayList<TraceEvent>();
				relevantTraces.add(relevantTrace);
				tracesStack.push(relevantTrace);
				active = true;
			}
			if (active)
				relevantTrace.add(e);
			if (e instanceof PatternExitEvent || e instanceof LightweightPatternExitEvent) {
				tracesStack.pop();
				if (!tracesStack.isEmpty()) {
					relevantTrace = tracesStack.peek();					
				} else {
					active = false;
				}
			}
		}
		List<TraceEvent[]> tempResult = new ArrayList<TraceEvent[]>();
		for (List<TraceEvent> tempRelevantTrace : relevantTraces) {
			tempResult.add(tempRelevantTrace.toArray(new TraceEvent[]{}));
		}
		return tempResult;
	}
	
	public static boolean isPMC0Fulfilled(StoryPattern storyPattern, ObjectVariable ov, TraceEvent[] patternOrPatternRunTrace) {
		boolean[] varStateSequence = getVarStateSequence(ov, patternOrPatternRunTrace);
		return PmcCovUtil.checkPMC0(varStateSequence);
	}

	public static boolean isPMC1Fulfilled(StoryPattern storyPattern, ObjectVariable ov, TraceEvent[] patternOrPatternRunTrace, int covLevel) {
		boolean[] varStateSequence = getVarStateSequence(ov, patternOrPatternRunTrace);
		return PmcCovUtil.checkPMC1(varStateSequence, covLevel);
	}
	
	public static boolean endsWithMatch(TraceEvent[] patternRunTrace) {
		for (TraceEvent e: patternRunTrace) {
			if (e instanceof MatchFoundEvent || e instanceof CommenceOfGraphRewritingEvent) {
				return true;
			} else if (e instanceof NoMatchFoundEvent) {
				return false;
			}
		}
		return false;
	}
	
	private static boolean[] getVarStateSequence(ObjectVariable ov, TraceEvent[] patternOrPatternRunTrace) {
		boolean[] varStateSequence = new boolean[patternOrPatternRunTrace.length];
		
		int i = 0;
		boolean flag = false;
		for (TraceEvent e : patternOrPatternRunTrace) {
			if (e instanceof BindObjectVarEvent) {
				String name = (String) ((BindObjectVarEvent) e).getTraceData();
				if (name.equals(ov.getName()))				
					flag = true;
			} else if (e instanceof UnbindObjectVarEvent) {
				String name = (String) ((UnbindObjectVarEvent) e).getTraceData();
				if (name.equals(ov.getName()))
					flag = false;
			} else if (e instanceof MatchFoundEvent || e instanceof NoMatchFoundEvent || e instanceof CommenceOfGraphRewritingEvent) {
				varStateSequence = Arrays.copyOfRange(varStateSequence, 0, i);
				break;
			}
			varStateSequence[i] = flag;
			i++;			
		}
		
		return varStateSequence;
	}
	
}
