package com.sree.programs.algorithms.recursion;

public class LongestPalindromicSubstring {
	// driver method
	public static void main(String args[]) {
		String input = "abdbca";
		// input = "aaaaaa";
		System.out.println(getLPSLengthRecursive(input, 0, input.length() - 1));

	}

	private static int getLPSLengthRecursive(String input, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			return 1;
		}
		if (startIndex == input.length() || endIndex == -1 || startIndex > endIndex) {
			return 0;
		} else {

			if (input.charAt(startIndex) == input.charAt(endIndex)) {
				int remainingLength = endIndex - startIndex - 1;

				if (remainingLength == getLPSLengthRecursive(input, startIndex + 1, endIndex - 1)) {
					return remainingLength + 2;
				}
			}

			int count1 = getLPSLengthRecursive(input, startIndex + 1, endIndex);
			int count2 = getLPSLengthRecursive(input, startIndex, endIndex - 1);

			return Math.max(count1, count2);
		}
	}

}
