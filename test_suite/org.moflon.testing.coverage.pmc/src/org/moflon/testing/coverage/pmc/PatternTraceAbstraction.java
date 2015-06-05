package org.moflon.testing.coverage.pmc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EClassifier;
import org.moflon.tracing.sdm.StackTraceWrapper;
import org.moflon.tracing.sdm.events.PatternEnterEvent;
import org.moflon.tracing.sdm.events.PatternExitEvent;
import org.moflon.tracing.sdm.events.TraceEvent;

import SDMLanguage.activities.StoryNode;
import SDMLanguage.patterns.ObjectVariable;

public class PatternTraceAbstraction {
	
	private final String storyPatternName;
	private final StoryNode pattern;
	private Map<StackTraceWrapper, List<TraceEvent[]>> patternRelevantTraceInfo = new HashMap<StackTraceWrapper, List<TraceEvent[]>>();
	
	public PatternTraceAbstraction(StoryNode pattern) {
		this.pattern = pattern;
		this.storyPatternName = pattern.getName();
	}
	
	public List<String> getVariables() {
		List<ObjectVariable> objectVariables = pattern.getStoryPattern().getObjectVariable();
		List<String> result = new ArrayList<String>(objectVariables.size());
		for (ObjectVariable obVar : objectVariables) {
			EClassifier type = obVar.getType();
			result.add(obVar.getName() + ":" + type.getName());
		}
		return result;
	}
	
	public void addTraces(Map<StackTraceWrapper, TraceEvent[]> operationTraces) {
		fillPatternTraces(operationTraces);
	}
	
	public String getPatternName() {
		return storyPatternName;
	}
	
	void fillPatternTraces(Map<StackTraceWrapper, TraceEvent[]> operationTraces) {
		for (StackTraceWrapper stw : operationTraces.keySet()) {
			TraceEvent[] trace = operationTraces.get(stw);
			
			List<List<TraceEvent>> relevantTraces = new ArrayList<List<TraceEvent>>();
			List<TraceEvent> relevantTrace = null;
			Stack<List<TraceEvent>> tracesStack = new Stack<List<TraceEvent>>();
			boolean active = false;
			for (int i = 0; i < trace.length; i++) {
				TraceEvent e = trace[i];
				if (e instanceof PatternEnterEvent) {				
					String tmpPatternName = ((PatternEnterEvent) e).getStoryPatternName();
					if (storyPatternName.equals(tmpPatternName)) {
						relevantTrace = new ArrayList<TraceEvent>();
						relevantTraces.add(relevantTrace);
						tracesStack.push(relevantTrace);
						active = true;
					} else {
						tracesStack.push(Collections.<TraceEvent>emptyList());
						active = false;
					}					
				}
				if (active)
					relevantTrace.add(e);
				if (e instanceof PatternExitEvent) {
					tracesStack.pop();
					if (!tracesStack.isEmpty()) {
						relevantTrace = tracesStack.peek();
						active = !relevantTrace.isEmpty();
					} else {
						active = false;
					}
				}
			}
			List<TraceEvent[]> tempResult = new ArrayList<TraceEvent[]>();
			for (List<TraceEvent> tempRelevantTrace : relevantTraces) {
				tempResult.add(tempRelevantTrace.toArray(new TraceEvent[]{}));
			}
			patternRelevantTraceInfo.put(stw, tempResult);
		}
	}
	
	public StoryNode getStoryNode() {
		return pattern;
	}
	
	public Map<StackTraceWrapper, List<TraceEvent[]>> getPatternRelevantTraces() {
		return Collections.unmodifiableMap(patternRelevantTraceInfo);
	}
}
