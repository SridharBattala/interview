package com.sree.programs.patterns.twopointers;

import java.util.*;

import com.sree.programs.datastructures.matrix.MatrixHelper;

public class TripletSumToZero {
	public static void main(String args[]) {
		int[] arr = { -3, 0, 1, 2, -1, 1, -2 };
		List<List<Integer>> output = getTripletSumToZero(arr);
		MatrixHelper.print(output);
	}

	public static List<List<Integer>> getTripletSumToZero(int[] arr) {
		List<List<Integer>> output = new LinkedList<>();
		// sort the array
		Arrays.sort(arr);
		// loop array
		for (int i = 0; i < arr.length - 2; i++) {
			if (i != 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			searchPair(arr, i, output);
		}
		return output;
	}

	private static void searchPair(int[] arr, int currentIndex, List<List<Integer>> output) {
		int left = currentIndex + 1;
		int right = arr.length - 1;
		int requiredSum = 0 - arr[currentIndex];
		while (left < right) {
			int currentSum = arr[left] + arr[right];
			if (currentSum == requiredSum) {
				output.add(Arrays.asList(arr[currentIndex], arr[left], arr[right]));
				while (left < right && arr[left] == arr[left + 1]) {
					left++;
				}
				while (left < right && arr[right] == arr[right - 1]) {
					right--;
				}
				left++;
				right--;
			} else if (currentSum > requiredSum) {
				while (left < right && arr[right] == arr[right - 1]) {
					right--;
				}
				right--;
			} else if (currentSum < requiredSum) {
				while (left < right && arr[left] == arr[left + 1]) {
					left++;
				}
				left++;
			}

		}

	}
}
