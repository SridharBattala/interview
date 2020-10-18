package com.sree.programs.patterns.cyclicsort;

import java.util.Arrays;

public class SmallestMissingPositiveNumber {
	public static void main(String[] args) {
		int output = findMissingNumber(new int[] { -3, 1, 5, 4, 2 });
		System.out.println("output=" + output);
	}

	private static int findMissingNumber(int[] arr) {
		// do cyclic sort range from 1 to n
		int index = 0;
		while (index <= arr.length - 1) {
			if (arr[index] > 0 && arr[index] <= arr.length && arr[index] - 1 != index) {
				swap(arr[index] - 1, index, arr);
				System.out.println("arr=" + Arrays.toString(arr));
			} else {
				index++;
			}
		}
		// check all the elements proper

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - 1 != i) {
				return i + 1;
			}
		}
		return arr.length;
	}

	private static void swap(int index1, int index2, int[] arr) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;

	}
}
