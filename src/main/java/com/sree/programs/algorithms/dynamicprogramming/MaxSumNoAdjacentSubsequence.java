package com.sree.programs.algorithms.dynamicprogramming;

public class MaxSumNoAdjacentSubsequence {
	public static void main(String[] args) {
		int[] input1 = new int[] { 1, -1, 6, -4, 2, 2 };
		int[] input2 = new int[] { 1, 6, 10, 14, -5, -1, 2, -1, 3 };
		System.out.println("Max sum of nonadjacent subsequence: " + findMaxSumNonadjacent(input1));
		System.out.println("Max sum of nonadjacent subsequence: " + findMaxSumNonadjacent(input2));

	}

	private static int findMaxSumNonadjacent(int[] input) {
		return findMaxSumNonadjacentRecursive(input, 0);
	}

	private static int findMaxSumNonadjacentRecursive(int[] input, int index) {
		if (index > input.length - 1) {
			return 0;
		} else {
			int count1 = input[index] + findMaxSumNonadjacentRecursive(input, index + 2);
			int count2 = findMaxSumNonadjacentRecursive(input, index + 1);
			return Math.max(count1, count2);
		}
	}
}
