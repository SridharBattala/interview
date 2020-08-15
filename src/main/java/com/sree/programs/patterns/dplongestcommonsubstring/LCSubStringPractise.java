package com.sree.programs.patterns.dplongestcommonsubstring;

public class LCSubStringPractise {
	public static void main(String[] args) {
		String string1 = "abdca";
		String string2 = "cbda";
		System.out.println("LCSubStringLength=" + findLCSubStringLength("abdca", "cbda"));
	}

	public static int findLCSubStringLength(String string1, String string2) {
		return findLCSubStringLengthRecursive(string1, string2, 0, 0, 0);
	}

	// String string1 = "abdca";
	// String string2 = "cbda";
	public static int findLCSubStringLengthRecursive(String string1, String string2, int string1Index, int string2Index,
			int count) {
		if (string1Index == string1.length() || string2Index == string2.length()) {
			return count;
		} else {

			if (string1.charAt(string1Index) == string2.charAt(string2Index)) {
				count = findLCSubStringLengthRecursive(string1, string2, string1Index + 1, string2Index + 1, count + 1);
			}
			int count1 = findLCSubStringLengthRecursive(string1, string2, string1Index + 1, string2Index, 0);
			int count2 = findLCSubStringLengthRecursive(string1, string2, string1Index, string2Index + 1, 0);
			System.out.println("count=" + count + "count1=" + count1 + ", count2=" + count2);
			return Math.max(count, Math.max(count1, count2));
		}
	}

}
