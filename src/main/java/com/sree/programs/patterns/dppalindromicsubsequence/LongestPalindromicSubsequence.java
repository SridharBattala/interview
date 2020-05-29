package com.sree.programs.patterns.dppalindromicsubsequence;

import java.util.*;

public class LongestPalindromicSubsequence {
	static String string = "abdbca";

	static Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("LCSLength TopDown=" + findLPSLengthTopDown(0, string.length() - 1, 0));
		System.out.println("LCSLength bottom up=" + findLCSLengthBottomUp());

	}

	private static int findLCSLengthBottomUp() {
		int[][] dp = new int[string.length()][string.length()];
		// assign 1 to if start index, end index are same
		for (int index = 0; index < string.length(); index++) {
			dp[index][index] = 1;
		}
		for (int startIndex = string.length() - 2; startIndex >= 0; startIndex--) {
			for (int endIndex = startIndex + 1; endIndex < string.length(); endIndex++) {
				int count1 = 0;
				if (string.charAt(startIndex) == string.charAt(endIndex)) {
					count1 = 2 + dp[startIndex + 1][endIndex - 1];
				}
				int count2 = dp[startIndex][endIndex - 1];
				int count3 = dp[startIndex + 1][endIndex];

				dp[startIndex][endIndex] = Math.max(count1, Math.max(count2, count3));
			}

		}

		return dp[0][string.length() - 1];
	}

	private static int findLPSLengthTopDown(int startIndex, int endIndex, int currentCount) {

		// base case 1
		if (startIndex > endIndex) {
			return 0;
		}
		// base case 2
		else if (startIndex == endIndex) {
			return currentCount + 1;
		}
		// recursive case
		else {
			if (!cache.containsKey(startIndex + "|" + endIndex + "|" + currentCount)) {

				int count1 = currentCount;
				if (string.charAt(startIndex) == string.charAt(endIndex)) {
					count1 = findLPSLengthTopDown(startIndex + 1, endIndex - 1, currentCount + 2);
				}
				int count2 = findLPSLengthTopDown(startIndex, endIndex - 1, currentCount);
				int count3 = findLPSLengthTopDown(startIndex + 1, endIndex, currentCount);

				cache.put(startIndex + "|" + endIndex + "|" + currentCount, Math.max(count1, Math.max(count2, count3)));

			}
			return cache.get(startIndex + "|" + endIndex + "|" + currentCount);

		}

	}

}
