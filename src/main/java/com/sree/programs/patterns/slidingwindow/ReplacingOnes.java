package com.sree.programs.patterns.slidingwindow;

import java.util.*;

class ReplacingOnes {
	public static int findLength(int[] inputArr, int k) {
		int windowStart = 0, maxRepeatedOnesCount = 0, maxLen = 0;
		Map<Integer, Integer> arraValueFrequencyMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < inputArr.length; windowEnd++) {
			int arrElement = inputArr[windowEnd];
			arraValueFrequencyMap.put(arrElement, arraValueFrequencyMap.getOrDefault(arrElement, 0) + 1);
			maxRepeatedOnesCount = Math.max(maxRepeatedOnesCount, arraValueFrequencyMap.get(arrElement));
			int windowSize = windowEnd - windowStart + 1;
			// shrink the window
			if (windowSize - maxRepeatedOnesCount > k) {
				int startElement = inputArr[windowStart];
				arraValueFrequencyMap.put(startElement, arraValueFrequencyMap.get(startElement) - 1);
				windowStart++;
			}
			maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
	}
}
