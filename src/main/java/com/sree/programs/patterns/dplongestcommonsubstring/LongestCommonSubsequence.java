package com.sree.programs.patterns.dplongestcommonsubstring;

import java.util.*;

public class LongestCommonSubsequence {
	static String string1 = "abdca";
	static String string2 = "cbda";
	static Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("LCSLength=" + findLCSLengthTopDown(0, 0, 0));
		System.out.println("LCSLength=" + findLCSLengthBottomUp());

	}

	private static int findLCSLengthBottomUp() {
		int[][] dp = new int[string1.length() + 1][string2.length() + 1];
		for (int index1 = 1; index1 < string1.length() + 1; index1++) {
			for (int index2 = 1; index2 < string2.length() + 1; index2++) {
				int count1 = 0;
				if (string1.charAt(index1 - 1) == string2.charAt(index2 - 1)) {
					count1 = 1 + dp[index1 - 1][index2 - 1];
				}
				int count2 = dp[index1 - 1][index2];
				int count3 = dp[index1][index2 - 1];

				dp[index1][index2] = Math.max(count1, Math.max(count2, count3));
			}

		}

		return dp[string1.length()][string2.length()];
	}

	private static int findLCSLengthTopDown(int currentIndex1, int currentIndex2, int currentCount) {
		// base case
		if (currentIndex1 == string1.length() || currentIndex2 == string2.length()) {
			return currentCount;
		}
		// recursive case
		else {
			if (!cache.containsKey(currentIndex1 + "|" + currentIndex2 + "|" + currentCount)) {

				int count1 = currentCount;
				if (string1.charAt(currentIndex1) == string2.charAt(currentIndex2)) {
					count1 = findLCSLengthTopDown(currentIndex1 + 1, currentIndex2 + 1, currentCount + 1);
				}
				int count2 = findLCSLengthTopDown(currentIndex1, currentIndex2 + 1, currentCount);
				int count3 = findLCSLengthTopDown(currentIndex1 + 1, currentIndex2, currentCount);

				cache.put(currentIndex1 + "|" + currentIndex2 + "|" + currentCount,
						Math.max(count1, Math.max(count2, count3)));

			}
			return cache.get(currentIndex1 + "|" + currentIndex2 + "|" + currentCount);

		}

	}

}
