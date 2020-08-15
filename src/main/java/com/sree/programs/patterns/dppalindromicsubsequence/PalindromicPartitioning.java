package com.sree.programs.patterns.dppalindromicsubsequence;

import java.io.*;

//Input: {2, 5, 1, 3, 6, 2, 4}
//Output: 15
//Explanation: The thief should steal from houses 5 + 6 + 4
class PalindromicPartitioning {
	public static void main(String[] args) {
		String input = "pp";
		int output = minCuts(input);
		System.out.println("output=" + output);
	}

//diver method
	public static int minCuts(String input) {
		return minCutsRecursive(input, 0, input.length() - 1);
	}

//recursive method
	public static int minCutsRecursive(String input, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		} else {
			int count1 = endIndex - startIndex + 1;
			if (input.charAt(startIndex) == input.charAt(endIndex)) {
				int remainingCount = minCutsRecursive(input, startIndex + 1, endIndex - 1);
				if (remainingCount == 0) {
					count1 = 0;
				}
			}
			int count2 = 1 + minCutsRecursive(input, startIndex + 1, endIndex);
			int count3 = 1 + minCutsRecursive(input, startIndex, endIndex - 1);
			// System.out.println("count1="+count1+",count2="+count2+", count3="+count3);
			return Math.min(Math.min(count1, count2), count3);
		}
	}
}
