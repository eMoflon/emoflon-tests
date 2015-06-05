package org.moflon.testing.coverage.pmc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.moflon.tracing.sdm.StackTraceWrapper;

import SDMLanguage.activities.StoryNode;

public class PatternPMCInformation {

	public static final int COMBINED_RUNS_INDEX = -1;
	
	private StoryNode storyPattern;
	private List<BindingVectorHolder> info = new ArrayList<PatternPMCInformation.BindingVectorHolder>();
	private List<String> varNames;
	
	public PatternPMCInformation(StoryNode storyPattern, List<String> varNames) {
		this.storyPattern = storyPattern;
		this.varNames = varNames;
	}
	
	public void addInformation(StackTraceWrapper stw, int runIndex, boolean[] bindingEntry) {
		getCurrent(stw, runIndex).addInfo(bindingEntry);
	}
	
	public void setCompleteMatch(StackTraceWrapper stw, int runIndex) {
		getCurrent(stw, runIndex).setCompleteMatch(true);
	}
	
	public boolean isCompleteMatch(StackTraceWrapper stw, int runIndex) {
		return getCurrent(stw, runIndex).isCompleteMatch();
	}

	private BindingVectorHolder getCurrent(StackTraceWrapper stw, int runIndex) {
		BindingVectorHolder current = null;
		for (BindingVectorHolder temp : info) {
			if (temp.getStw().equals(stw) && temp.getRunIndex() == runIndex) {
				current = temp;
				break;
			}
		}
		if (current == null) {
			current = new BindingVectorHolder(stw, runIndex, varNames);
			info.add(current);
		}
		return current;
	}
	
	public List<boolean[]> getBindingVector(StackTraceWrapper stw, int runIndex) {
		for (BindingVectorHolder temp : info) {
			if (temp.getStw().equals(stw) && temp.getRunIndex() == runIndex) {
				return temp.getBindingVector();
			}
		}
		return null;
	}
	
	public int getMaxRunIndex() {
		return info.size()-1;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		if (!(obj instanceof PatternPMCInformation))
//			return false;
//		PatternPMCInformation temp = (PatternPMCInformation) obj;
//		return (temp.storyPattern.equals(this.storyPattern));
//	}
//	
//	@Override
//	public int hashCode() {		
//		return storyPattern.hashCode();
//	}

	private class BindingVectorHolder {
		private StackTraceWrapper stw;
		private List<String> varNames;
		private List<boolean[]> bindingVector;
		final int varCount;
		final int runIndex;
		private boolean isCompleteMatch;
		
		public BindingVectorHolder(StackTraceWrapper stw, int runIndex, List<String> varNames) {
			this.stw = stw;
			this.runIndex = runIndex;
			this.varNames = varNames;
			varCount = varNames.size();
			bindingVector = new LinkedList<boolean[]>();
		}
		
		public void addInfo(boolean[] data) {
			if (data.length != varCount)
				throw new IllegalStateException();
			bindingVector.add(data);
		}

		public StackTraceWrapper getStw() {
			return stw;
		}
		
		public int getRunIndex() {
			return runIndex;
		}

		public List<String> getVarNames() {
			return varNames;
		}

		public List<boolean[]> getBindingVector() {
			return bindingVector;
		}

		public boolean isCompleteMatch() {
			return isCompleteMatch;
		}
		
		private void setCompleteMatch(boolean b) {
			isCompleteMatch = b;
		}
		
	}
}


