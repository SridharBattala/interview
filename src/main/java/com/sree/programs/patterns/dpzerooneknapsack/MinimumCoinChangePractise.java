package com.sree.programs.patterns.dpzerooneknapsack;

import java.util.*;

public class MinimumCoinChangePractise {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3 };
		int target = 6;

		System.out.println("minimum coins count=" + minimumCoinsCount(arr, target));
	}

	private static int minimumCoinsCount(int[] arr, int target) {
		int minCoin = minimumCoinsCountRecursive(arr, target, 0, 0);
		if (minCoin == arr.length + 1) {
			return Integer.MAX_VALUE;
		}
		return minCoin;
	}

	private static int minimumCoinsCountRecursive(int[] arr, int target, int currentSum, int currentIndex) {
		if (currentSum == target) {
			return 0;
		} else if (currentSum > target || currentIndex > arr.length - 1) {
			return Integer.MAX_VALUE;
		} else {
			int case1 = Integer.MAX_VALUE;
			int minCount = minimumCoinsCountRecursive(arr, target, currentSum + arr[currentIndex], currentIndex);
			if (minCount != Integer.MAX_VALUE) {
				case1 = minCount + 1;
			}
			int case2 = minimumCoinsCountRecursive(arr, target, currentSum, currentIndex + 1);
			System.out.println("current element=" + arr[currentIndex] + ", case1=" + case1 + ", case2=" + case2);
			return Math.min(case1, case2);

		}

	}

}
