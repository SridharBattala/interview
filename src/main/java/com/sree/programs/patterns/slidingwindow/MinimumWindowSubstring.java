package com.sree.programs.patterns.slidingwindow;

import java.util.*;

class MinimumWindowSubstring {
	public static String findSubstring(String input, String pattern) {
		// pattern freq map
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int index = 0; index < pattern.length(); index++) {
			char ch = pattern.charAt(index);
			charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
		}
		// loop input
		int windowStart = 0, matched = 0, subStrStartIndex = 0, subStrEndIndex = 0;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char ch = input.charAt(windowEnd);
			if (charFreqMap.containsKey(ch)) {
				charFreqMap.put(ch, charFreqMap.get(ch) - 1);
				if (charFreqMap.get(ch) == 0) {
					matched++;
				}
			}
			while (matched == charFreqMap.size()) {
				subStrStartIndex = windowStart;
				subStrEndIndex = windowEnd + 1;
				char startChar = input.charAt(windowStart);
				if (charFreqMap.containsKey(startChar)) {
					if (charFreqMap.get(startChar) == 0) {
						matched--;
					}
					charFreqMap.put(startChar, charFreqMap.get(startChar) + 1);

				}
				windowStart++;
			}
		}
		return input.substring(subStrStartIndex, subStrEndIndex);

	}

	public static void main(String[] args) {
		System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
		System.out.println(MinimumWindowSubstring.findSubstring("aaaabdec", "aae"));
		System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
	}
}
