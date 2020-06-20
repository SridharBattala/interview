package com.sree.programs.patterns.twopointers;

import java.util.*;

class TripletWithSmallerSum {

	public static void main(String[] args) {
		System.out.println(tripletWithSmallerSumCount(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(tripletWithSmallerSumCount(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

	private static int tripletWithSmallerSumCount(int[] input, int target) {
		// sort the array
		Arrays.sort(input);
		int outputCount = 0;
		// loop array
		for (int index = 0; index < input.length - 2; index++) {
			int left = index + 1;
			int right = input.length - 1;
			while (left < right) {
				int sum = input[index] + input[left] + input[right];

				if (target > sum) {
					outputCount = outputCount + (right - left);

					left++;
				} else {
					right--;
				}
			}
		}
		return outputCount;
	}
}
