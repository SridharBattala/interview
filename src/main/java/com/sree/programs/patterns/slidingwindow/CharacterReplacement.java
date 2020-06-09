package com.sree.programs.patterns.slidingwindow;

import java.util.*;

public class CharacterReplacement {
	public static void main(String[] args) {
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
		System.out.println(CharacterReplacement.findLength("aabcdeb", 2));
		System.out.println(CharacterReplacement.findLength("abccde", 1));
	}

	private static int findLength(String input, int k) {
		Map<Character, Integer> letterFreqMap = new HashMap<>();
		int maxLen = 0, windowStart = 0, maxRepeatCount = 0;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char ch = input.charAt(windowEnd);
			letterFreqMap.put(ch, letterFreqMap.getOrDefault(ch, 0) + 1);
			maxRepeatCount = Math.max(maxRepeatCount, letterFreqMap.get(ch));
			int windowSize = windowEnd - windowStart + 1;
			if (windowSize - maxRepeatCount > k) {
				char windowStartChar = input.charAt(windowStart);
				letterFreqMap.put(windowStartChar, letterFreqMap.get(windowStartChar) - 1);
				windowStart++;
			}

			maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
		}
		return maxLen;
	}
}
