package com.sree.programs.patterns.dpzerooneknapsack;

public class MinimumSubsetSumDiff {
	static int[] num = { 1, 3, 100, 4 };
	static int halfSum = 0;
	static int sum = 0;

	public static int canPartition(int[] num) {

		for (int i = 0; i < num.length; i++)
			sum += num[i];

		// if 'sum' is a an odd number, we can't have two subsets with equal sum

		halfSum = sum / 2;
		int closestToHalfSum = getClosestSum(0, 0);
		int sum2 = sum - closestToHalfSum;
		return sum2 - closestToHalfSum;

	}

	private static int getClosestSum(int currentSum, int currentIndex) {
		if (currentSum > halfSum) {
			return currentSum - num[currentIndex - 1];
		} else if (currentIndex > num.length - 1) {
			return currentSum;
		}

		else {
			int sum1 = getClosestSum(currentSum + num[currentIndex], currentIndex + 1);
			System.out.println("sum1=" + sum1);

			int sum2 = getClosestSum(currentSum, currentIndex + 1);

			System.out.println("sum2=" + sum2);
			return Math.max(sum1, sum2);

		}

	}

	public static void main(String[] args) {

		System.out.println(canPartition(num));
		// num = new int[] { 1, 2, 7, 1, 5 };
		// System.out.println(canPartition(num));
		// num = new int[] { 1, 3, 100, 4 };
		// System.out.println(canPartition(num));
	}
}
