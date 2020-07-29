package com.sree.programs.datastructures.strings;

/**
 * https://leetcode.com/articles/regular-expression-matching/#
 */
import java.util.Arrays;

class RegularExpressionDP {

	public static void main(String args[]) {
		System.out.println("Matched=" + isMatch("fabbbc", ".ab*c"));
		boolean matched = ((1 == 2) || (2 == 2) && (3 == 1));
		// System.out.println(matched);

	}

	public static boolean isMatch(String text, String pattern) {
		return dpRecursive(0, 0, text, pattern);
	}

	// fabbbc
	// .ab*c
	public static boolean dpRecursive(int textIndex, int patternIndex, String text, String pattern) {

		if (patternIndex == pattern.length() && textIndex == text.length()) {
			return true;
		} else {

			boolean first_match = textIndex < text.length() && patternIndex < pattern.length()
					&& (pattern.charAt(patternIndex) == text.charAt(textIndex) || pattern.charAt(patternIndex) == '.');
			boolean ans = false;
			if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
				ans = dpRecursive(textIndex, patternIndex + 2, text, pattern)
						|| (first_match && dpRecursive(textIndex + 1, patternIndex, text, pattern));
			} else {
				ans = first_match && dpRecursive(textIndex + 1, patternIndex + 1, text, pattern);
			}
			System.out.println("textIndex=" + textIndex + ",  patternIndex=" + patternIndex + ", value=" + ans);
			return ans;
		}

	}
}