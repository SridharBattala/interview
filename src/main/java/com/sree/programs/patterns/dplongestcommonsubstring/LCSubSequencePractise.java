package com.sree.programs.patterns.dplongestcommonsubstring;

public class LCSubSequencePractise {
	public static void main(String[] args) {
		String string1 = "abdca";
		String string2 = "cbda";
		System.out.println("LCSLength=" + findLCSLength(string1, string2));
	}

	/*
	 * sub sequence
	 */
	public static int findLCSLength(String string1, String string2) {
		return findLCSLengthRecursive(string1, string2, 0, 0);
	}

	public static int findLCSLengthRecursive(String string1, String string2, int string1Index, int string2Index) {
		if (string1Index == string1.length() || string2Index == string2.length()) {
			return 0;
		} else {
			int count1 = 0;
			if (string1.charAt(string1Index) == string2.charAt(string2Index)) {
				count1 = 1 + findLCSLengthRecursive(string1, string2, string1Index + 1, string2Index + 1);
			}
			int count2 = findLCSLengthRecursive(string1, string2, string1Index + 1, string2Index);
			int count3 = findLCSLengthRecursive(string1, string2, string1Index, string2Index + 1);
			return Math.max(count1, Math.max(count2, count3));
		}
	}
}
