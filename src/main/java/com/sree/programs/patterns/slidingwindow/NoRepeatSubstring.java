package com.sree.programs.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
	public static void main(String args[]) {
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));

	}

	public static int findLength(String input) {
		int windowStart = 0;
		// map contains last index of element
		Map<Character, Integer> charIndexMap = new HashMap<>();
		int maxLen = 0;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char ch = input.charAt(windowEnd);

			if (charIndexMap.containsKey(ch)) {
				// update start
				windowStart = Math.max(windowStart, charIndexMap.get(ch) + 1);
			}
			maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
			// update with latest index
			charIndexMap.put(ch, windowEnd);

		}
		return maxLen;
	}
}
