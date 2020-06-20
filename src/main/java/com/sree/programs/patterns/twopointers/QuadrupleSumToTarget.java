package com.sree.programs.patterns.twopointers;

import java.util.Arrays;
import java.util.*;

public class QuadrupleSumToTarget {
	public static void main(String[] args) {
		System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
	}

	private static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		List<List<Integer>> output = new LinkedList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 3; i++) {
			// handle duplicates
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < arr.length - 2; j++) {
				// handle duplicates
				if (j > i + 1 && arr[j] == arr[j - 1]) {
					continue;
				}
				// two pointers
				int left = j + 1, right = arr.length - 1;
				while (left < right) {
					int sum = arr[i] + arr[j] + arr[left] + arr[right];
					if (sum == target) {
						output.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
						// System.out.println(output);
						left++;
						right--;
						while (right > 0 && arr[right] == arr[right - 1]) {
							right--;
						}
						while (left < arr.length - 1 && arr[left] == arr[left + 1]) {
							left++;
						}

					} else if (sum > target) {

						right--;

					} else if (sum < target) {

						left++;
					}
				}
			}
		}
		return output;
	}

}
