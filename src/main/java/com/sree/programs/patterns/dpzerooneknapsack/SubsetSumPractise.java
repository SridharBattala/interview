package com.sree.programs.patterns.dpzerooneknapsack;

import java.util.*;

public class SubsetSumPractise {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3 };
		int target = 7;
		// System.out.println("checkForTragetSum=" + checkForTragetSum(arr, target));
		// System.out.println("tragetSumCount=" + tragetSumCount(arr, target));
		// LinkedList<LinkedList<Integer>> output = tragetSumSubsets(arr, target);
		// System.out.println("tragetSumSubsets=");
		/*
		 * for (LinkedList<Integer> subset : output) {
		 * System.out.println(subset.toString()); }
		 */
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
			return arr.length + 1;
		} else {
			int case1 = 1 + minimumCoinsCountRecursive(arr, target, currentSum + arr[currentIndex], currentIndex + 1);
			int case2 = minimumCoinsCountRecursive(arr, target, currentSum, currentIndex + 1);
			System.out.println("current element=" + arr[currentIndex] + ", case1=" + case1 + ", case2=" + case2);
			return Math.min(case1, case2);

		}

	}

	private static LinkedList<LinkedList<Integer>> tragetSumSubsets(int[] arr, int target) {
		LinkedList<LinkedList<Integer>> output = new LinkedList<>();
		LinkedList<Integer> callStack = new LinkedList<>();
		tragetSumSubsetsRecursive(arr, target, 0, 0, callStack, output);
		return output;
	}

	private static void tragetSumSubsetsRecursive(int[] arr, int target, int currentSum, int currentIndex,
			LinkedList<Integer> callStack, LinkedList<LinkedList<Integer>> output) {
		if (currentSum == target) {
			output.add(new LinkedList<>(callStack));
			return;
		} else if (currentSum > target || currentIndex > arr.length - 1) {
			return;
		} else {

			LinkedList<Integer> newCallStack = new LinkedList<>(callStack);
			newCallStack.add(arr[currentIndex]);
			tragetSumSubsetsRecursive(arr, target, currentSum + arr[currentIndex], currentIndex + 1, newCallStack,
					output);
			tragetSumSubsetsRecursive(arr, target, currentSum, currentIndex + 1, callStack, output);

		}
	}

	private static int tragetSumCount(int[] arr, int target) {
		return tragetSumCountRecursive(arr, target, 0, 0);
	}

	private static int tragetSumCountRecursive(int[] arr, int target, int currentSum, int currentIndex) {
		if (currentSum == target) {
			return 1;
		} else if (currentSum > target || currentIndex > arr.length - 1) {
			return 0;
		} else {

			int case1 = tragetSumCountRecursive(arr, target, currentSum + arr[currentIndex], currentIndex + 1);
			int case2 = tragetSumCountRecursive(arr, target, currentSum, currentIndex + 1);
			return case1 + case2;
		}
	}

	private static boolean checkForTragetSum(int[] arr, int target) {
		return checkForTragetSumRecursive(arr, target, 0, 0);
	}

	private static boolean checkForTragetSumRecursive(int[] arr, int target, int currentSum, int currentIndex) {
		if (currentSum == target) {
			return true;
		} else if (currentSum > target || currentIndex > arr.length - 1) {
			return false;
		} else {

			boolean case1 = checkForTragetSumRecursive(arr, target, currentSum + arr[currentIndex], currentIndex + 1);
			boolean case2 = checkForTragetSumRecursive(arr, target, currentSum, currentIndex + 1);
			return case1 || case2;
		}

	}
}
