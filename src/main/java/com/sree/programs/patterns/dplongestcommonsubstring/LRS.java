package com.sree.programs.patterns.dplongestcommonsubstring;

public class LRS {
	public static void main(String[] args) {

		System.out.println(findLRSLength("tomorrow"));
		System.out.println(findLRSLength("aabdbcec"));
		System.out.println(findLRSLength("fmff"));
	}

	private static int findLRSLength(String input) {
		return findLRSLengthRecursive(input, 0, 0);
	}

	private static int findLRSLengthRecursive(String input, int index1, int index2) {
		if (index1 == input.length() || index2 == input.length()) {
			return 0;
		} else {
			if (index1 != index2 && input.charAt(index1) == input.charAt(index2)) {
				return 1 + findLRSLengthRecursive(input, index1 + 1, index2 + 1);
			}
			int count1 = findLRSLengthRecursive(input, index1, index2 + 1);
			int count2 = findLRSLengthRecursive(input, index1 + 1, index2);
			return Math.max(count1, count2);
		}

	}
}
