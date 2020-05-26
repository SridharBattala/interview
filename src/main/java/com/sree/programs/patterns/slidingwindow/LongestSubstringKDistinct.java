package com.sree.programs.patterns.slidingwindow;

import java.util.*;

public class LongestSubstringKDistinct {
	public static void main(String args[]) {
		String s = "cbbebi";
		int k = 3;// distinctCharacterCount
		System.out.println("max length=" + findLongestSubstringKDistinct(s, k));
	}

	private static int findLongestSubstringKDistinct(String input, int distinctCharacterCount) {
		// base cases
		if (input == null || input.isEmpty() || distinctCharacterCount > input.length()) {
			throw new IllegalArgumentException();
		}
		// program start
		Map<Character, Integer> frequencyMap = new HashMap<>();
		int windowStart = 0;
		int maxLength = 0;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char currentChar = input.charAt(windowEnd);
			frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
			while (frequencyMap.size() > distinctCharacterCount) {

				char startChar = input.charAt(windowStart);
				frequencyMap.put(startChar, frequencyMap.getOrDefault(startChar, 0) - 1);
				if (frequencyMap.get(startChar) == 0) {
					frequencyMap.remove(startChar);
				}
				windowStart = windowStart + 1;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

		}
		return maxLength;
	}
}
