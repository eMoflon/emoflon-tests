package org.moflon.testing.coverage.pmc;

import java.util.List;

public class PmcCovUtil {

	static boolean[] getTraceInfoSequenceForIndex(int index, List<boolean[]> bindingVector) {
		boolean[] vec = new boolean[bindingVector.size()];
		int i = 0;
		for (boolean[] traceEntry : bindingVector) {
			vec[i] = traceEntry[index];
			i++;
		}
		return vec;
	}
	
	static boolean checkPMC0(boolean[] varStateSequence) {
		if (varStateSequence.length == 0)
			return false;
		
		if (varStateSequence[0] == true)
			return false;
		
		for (boolean temp : varStateSequence) {
			if (temp)
				return true;
		}
		
		return false;
	}
	
	static boolean checkPMC1(boolean[] varStateSequence, int covLevel) {
		if (varStateSequence.length == 0)
			return false;
		
		if (varStateSequence[0] == true)
			return false;
		
		int count = -1;
		boolean last = false;
		for (boolean next : varStateSequence) {
			if (next == last)
				continue;
			if (next) {
				count++;
			}
			last = next;
		}
		
		return (count >= covLevel);
	}
	
	static boolean checkPMC2(boolean[] varStateSequenceA, boolean[] varStateSequenceB, int covLevel) {
		if (varStateSequenceA.length == 0 || varStateSequenceB.length == 0)
			return false;
		
		if (varStateSequenceA[0] == true || varStateSequenceB[0] == true)
			return false;
		if (varStateSequenceA.length != varStateSequenceB.length)
			throw new IllegalStateException();
		
		int count = 0;		
		boolean optionsAvailable = true;
		boolean foundPattern = false;
		for (int i = 1; (i < varStateSequenceA.length) && optionsAvailable; i++) {
			foundPattern = false;
			boolean nextA = varStateSequenceA[i];
			boolean nextB = varStateSequenceB[i];
			
			if (nextA && nextB) {
				int i2 = i+1;
				while (i2 < varStateSequenceA.length && optionsAvailable) {
					nextA = varStateSequenceA[i2];
					if (!nextA) {
						int i3 = i2+1;
						while (i3 < varStateSequenceA.length && optionsAvailable) {
							nextA = varStateSequenceA[i3];
							nextB = varStateSequenceB[i3];
							if (nextA && nextB) {
								int i4 = i3+1;
								while (i4 < varStateSequenceA.length && optionsAvailable) {									
									nextB = varStateSequenceB[i4];
									if (!nextB) {
										int i5 = i4+1;
										while (i5 < varStateSequenceA.length && optionsAvailable) {
											nextA = varStateSequenceA[i5];
											nextB = varStateSequenceB[i5];
											if (nextA && nextB) {
												count++;
												i = i5-1;
												foundPattern = true;
												break;
											}											
											i5++;
											optionsAvailable = optionsAvailable && (i5 < varStateSequenceA.length);
										}
										if (foundPattern)
											break;
									}
									i4++;
									optionsAvailable = optionsAvailable && (i4 < varStateSequenceA.length);
								}
								if (foundPattern)
									break;
							}
							i3++;
							optionsAvailable = optionsAvailable && (i3 < varStateSequenceA.length);
						}
						if (foundPattern)
							break;
					}
					i2++;
					optionsAvailable = optionsAvailable && (i2 < varStateSequenceA.length);
				}
			}
		}
		
		return (count >= covLevel);
	}
}
