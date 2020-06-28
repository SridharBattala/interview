package com.sree.programs.patterns.dpzerooneknapsack;

import java.util.*;

class PartitionSet {

	public boolean canPartition(int[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];

		// if 'sum' is a an odd number, we can't have two subsets with equal sum
		if (sum % 2 != 0)
			return false;
		return canPartitionRecursive(num, sum / 2, 0);

	}

	private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
		// base check
		if (sum == 0) {

			return true;
		}

		else if (num.length == 0 || currentIndex > num.length - 1) {
			return false;
		}

		else {
			return canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)

					|| canPartitionRecursive(num, sum, currentIndex + 1);

		}

	}

	public static void main(String[] args) {
		PartitionSet ps = new PartitionSet();
		int[] num = { 1, 2, 3, 4 };
		System.out.println(ps.canPartition(num));

	}
}
