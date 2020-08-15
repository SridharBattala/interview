package com.sree.programs.patterns.dppalindromicsubsequence;

import java.util.*;

public class LongestPalindromicSubsequencePractise {

	public static void main(String[] args) {
		String string = "abdbca";
		System.out.println("LCSLength TopDown=" + findLPSLength(string, 0, string.length() - 1));

	}

	private static int findLPSLength(String string, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		} else if (startIndex == endIndex) {
			return 1;
		} else {

			int count1 = 0;
			if (string.charAt(startIndex) == string.charAt(endIndex)) {
				count1 = 2 + findLPSLength(string, startIndex + 1, endIndex - 1);
			}

			int count2 = findLPSLength(string, startIndex + 1, endIndex);
			int count3 = findLPSLength(string, startIndex, endIndex - 1);
			return Math.max(count1, Math.max(count2, count3));
		}
	}

}
