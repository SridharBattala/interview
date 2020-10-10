package com.sree.programs.datastructures.strings;

/**
 * https://leetcode.com/articles/regular-expression-matching/#
 */
import java.util.Arrays;

class RegularExpressionDPPractise {

	public static void main(String args[]) {
		System.out.println("Matched=" + isMatch("fabbbc", ".ab*c"));
		boolean matched = ((1 == 2) || (2 == 2) && (3 == 1));
		// System.out.println(matched);

	}

	public static boolean isMatch(String text, String pattern) {
		return isMatchRecursive(text, pattern, 0, 0);
	}

	public static boolean isMatchRecursive(String text, String pattern, int textIndex, int patterenIndex) {

		if (textIndex == text.length() && patterenIndex == pattern.length()) {
			return true;
		} else if (textIndex >= text.length() || patterenIndex >= pattern.length()) {
			return false;
		} else {

			boolean case1 = false;
			boolean case2 = false;
			if (text.charAt(textIndex) == pattern.charAt(patterenIndex) || pattern.charAt(patterenIndex) == '.') {
				case1 = isMatchRecursive(text, pattern, textIndex + 1, patterenIndex + 1);
			}
			if (patterenIndex + 1 < pattern.length() && pattern.charAt(patterenIndex + 1) == '*') {
				case2 = isMatchRecursive(text, pattern, textIndex + 1, patterenIndex)
						|| isMatchRecursive(text, pattern, textIndex, patterenIndex + 2);
			}
			System.out.println(
					"text index=" + textIndex + ", patterenIndex=" + patterenIndex + ", result=" + (case1 || case2));
			return case1 || case2;
		}

	}
}