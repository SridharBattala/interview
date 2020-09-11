package com.sree.programs.important.leetcodetop75;

import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		String[] dictionary = { "I", "have", "Jain", "Sumit", "am", "this", "dog" };
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("bce");
		set.add("d");
		set.add("c");
		String input = "abcd";

		boolean output = checkForwordBreak(set, input, 0, 0);
		System.out.println("output=" + output);
	}

	private static boolean checkForwordBreak(Set<String> set, String input, int startIndex, int endIndex) {
		if (endIndex > input.length() - 1 || startIndex > input.length() - 1) {
			return false;
		}
		String subString = input.substring(startIndex, endIndex + 1);
		System.out.println("subString=" + subString);
		boolean case1 = false;
		if (set.contains(subString)) {
			if (endIndex == input.length() - 1) {
				case1 = true;
			} else {
				// System.out.println("step 1=");
				case1 = checkForwordBreak(set, input, endIndex + 1, endIndex + 1);
			}

		}
		// System.out.println("step 2=");
		boolean case2 = checkForwordBreak(set, input, startIndex, endIndex + 1);
		return case1 || case2;

	}
}
