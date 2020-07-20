package com.sree.programs.algorithms.dynamicprogramming;

import java.util.Arrays;

public class LargestSumSubarray {
	public static void main(String[] args) {
		int[] v = new int[] { -4, 2, -5, 1, 2, 3, 6, -5, 1 };
		System.out.println("Sum of largest subarray: " + findMaxSumSubArray(v));
	}

	private static int findMaxSumSubArray(int[] input) {
		// TODO Auto-generated method stub
		return findMaxSumSubArrayRecursive(input, 0, input.length - 1);
	}

	private static int findMaxSumSubArrayRecursive(int[] input, int startIndex, int endIndex) {
		if (startIndex == input.length) {
			return 0;
		} else {
			int count1 = 0;

			for (int i = startIndex; i <= endIndex; i++) {
				int sum = 0;
				for (int j = startIndex; j <= i; j++) {
					sum = sum + input[j];
				}
				count1 = Math.max(sum, count1);
			}

			int count2 = findMaxSumSubArrayRecursive(input, startIndex + 1, endIndex);
			return Math.max(count1, count2);
		}
	}

}
