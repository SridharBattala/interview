package com.sree.programs.important.amazonquestions;

/*
 * https://leetcode.com/discuss/interview-question/370112
 */
import java.util.*;

public class DistinctCharSubStringCopy {
	public static void main(String[] args) {

		System.out.println(findDistinctCharSubStrings("democracy", 5));
		System.out.println(findDistinctCharSubStrings("abcabc", 3));
		System.out.println(findDistinctCharSubStrings("abacab", 3));

	}

	private static List<String> findDistinctCharSubStrings(String input, int target) {
		Map<Character, Integer> freqMap = new LinkedHashMap<>();
		int start = 0;
		List<String> output = new LinkedList<>();
		for (int end = 0; end < input.length(); end++) {
			freqMap.put(input.charAt(end), freqMap.getOrDefault(input.charAt(end), 0) + 1);
			if (freqMap.size() == target && end - start + 1 == target) {
				output.add(input.substring(start, end + 1));

			}
			if (end - start + 1 >= target) {
				char startChar = input.charAt(start);
				freqMap.put(startChar, freqMap.getOrDefault(startChar, 0) - 1);
				if (freqMap.get(startChar) == 0) {
					freqMap.remove(startChar);
				}
				start++;
			}
			// System.out.println("start="+input.charAt(start),", end="+input.charAt(end)+);

		}
		// Collections.sort(output);
		return output;
	}
}
