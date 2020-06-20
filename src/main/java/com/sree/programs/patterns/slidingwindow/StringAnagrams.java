package com.sree.programs.patterns.slidingwindow;

import java.util.*;

public class StringAnagrams {
	public static void main(String[] args) {
		System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
		System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
	}

	private static List<Integer> findStringAnagrams(String input, String pattern) {
		// create freq map for pattern
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {

			charFreqMap.put(pattern.charAt(i), charFreqMap.getOrDefault(i, 0) + 1);
		}
		// loop input
		List<Integer> output = new LinkedList<>();
		int windowStart = 0, matched = 0;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char ch = input.charAt(windowEnd);
			if (charFreqMap.containsKey(ch)) {
				charFreqMap.put(ch, charFreqMap.get(ch) - 1);
				if (charFreqMap.get(ch) == 0) {
					matched++;
				}

			}
			if (matched == charFreqMap.size()) {
				output.add(windowStart);
			}
			// shrink the window
			if (windowEnd >= pattern.length() - 1) {
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

		return output;
	}

}
