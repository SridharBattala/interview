package com.sree.programs.important.amazonquestions;

/*
 * https://leetcode.com/discuss/interview-question/370112
 */
import java.util.*;

public class DistinctCharSubString {
	public static void main(String[] args) {

		System.out.println(findDistinctCharSubStrings("abacab", 3));
		System.out.println(findDistinctCharSubStrings("abcabc", 3));
	}

	private static List<String> findDistinctCharSubStrings(String input, int target) {
		Map<Character, Integer> freqMap = new HashMap<>();
		int start = 0;
		List<String> output = new LinkedList<>();
		for (int end = 0; end < input.length(); end++) {
			freqMap.put(input.charAt(end), freqMap.getOrDefault(input.charAt(end), 0) + 1);
			if (freqMap.size() == target && end - start + 1 == target) {
				output.add(input.substring(start, end + 1));
			} else if (freqMap.size() == target) {
				// shrink the window
				while (freqMap.size() >= target && end - start + 1 >= target) {

					if (start < input.length()) {
						char startChar = input.charAt(start);
						freqMap.put(startChar, freqMap.getOrDefault(startChar, 0) - 1);
						if (freqMap.get(startChar) == 0) {
							freqMap.remove(startChar);
						}
						start++;
						if (freqMap.size() == target && end - start + 1 == target) {
							output.add(input.substring(start, end + 1));
						}

					}

				}
			}
			// System.out.println("start="+input.charAt(start),", end="+input.charAt(end)+);

		}
		return output;
	}
}
