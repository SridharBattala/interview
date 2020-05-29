package com.sree.programs.patterns.dpzerooneknapsack;

import com.sree.programs.datastructures.matrix.MatrixHelper;

public class SubsetSum {
	private static int[] num = { 1, 2, 3, 7 };

	public static void main(String[] args) {

		System.out.println("Subset Sum=" + checkSubsetSumTopDown(6, 0));
		System.out.println("Subset Sum=" + checkSubsetSumBottomUp(6));
	}

	private static boolean checkSubsetSumTopDown(int currentSum, int currentIndex) {
		// base case 1
		if (currentSum == 0) {
			return true;
		}
		// base case 2
		else if (currentIndex == num.length) {
			return false;
		} else {
			return checkSubsetSumTopDown(currentSum - num[currentIndex], currentIndex + 1)
					|| checkSubsetSumTopDown(currentSum, currentIndex + 1);
		}
	}

	private static boolean checkSubsetSumBottomUp(int sum) {
		// define bool array
		boolean[][] arr = new boolean[num.length][sum + 1];
		// we can make zero sum with empty array
		// fill first column
		for (int inputIndex = 0; inputIndex < num.length; inputIndex++) {
			arr[inputIndex][0] = true;
		}
		// fill first row
		for (int currentSum = 1; currentSum <= sum; currentSum++) {
			if (currentSum == num[0]) {
				arr[0][currentSum] = true;
			} else {
				arr[0][currentSum] = false;
			}

		}

		// fill the array
		for (int inputIndex = 1; inputIndex < num.length; inputIndex++) {
			for (int currentSum = 1; currentSum <= sum; currentSum++) {
				if (currentSum >= num[inputIndex]) {
					arr[inputIndex][currentSum] = arr[inputIndex - 1][currentSum]
							|| arr[inputIndex - 1][currentSum - num[inputIndex]];
				} else {
					arr[inputIndex][currentSum] = arr[inputIndex - 1][currentSum];
				}
			}
		}
		MatrixHelper.print(arr);
		return arr[num.length - 1][sum];
	}
}
