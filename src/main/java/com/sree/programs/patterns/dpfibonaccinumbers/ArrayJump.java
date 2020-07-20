package com.sree.programs.patterns.dpfibonaccinumbers;

public class ArrayJump {
	public static void main(String args[]) {
		int[] arr1 = { 2, 1, 1, 1, 4 };
		int[] arr2 = { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
		System.out.println("numberOfWays=" + findMinimumJumps(arr1));
		System.out.println("numberOfWays=" + findMinimumJumps(arr2));
	}

	// driver method
	private static int findMinimumJumps(int[] arr) {
		return findMinimumJumpsRecursive(arr, 0);
	}

	private static int findMinimumJumpsRecursive(int[] arr, int currentIndex) {
		if (currentIndex == arr.length - 1) {
			return 0;
		} else {
			int currentIndexValue = arr[currentIndex];
			int minJumps = Integer.MAX_VALUE;
			for (int i = 1; i <= currentIndexValue; i++) {
				if (currentIndex + i < arr.length && arr[currentIndex + i] != 0) {
					int jumps = 1 + findMinimumJumpsRecursive(arr, currentIndex + i);
					minJumps = Math.min(minJumps, jumps);
				}

			}
			return minJumps;
		}
	}
}
