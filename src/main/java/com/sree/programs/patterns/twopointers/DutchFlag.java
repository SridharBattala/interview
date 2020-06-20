package com.sree.programs.patterns.twopointers;

public class DutchFlag {
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 2, 1, 0 };
		DutchFlag.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 2, 2, 0, 1, 2, 0 };
		DutchFlag.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
	}

	private static void sort(int[] arr) {
		int high = arr.length - 1;
		int low = 0;
		for (int i = 0; i <= high;) {
			if (arr[i] == 0) {
				swap(arr, low, i);
				i++;
				low++;
			} else if (arr[i] == 1) {
				i++;
			} else if (arr[i] == 2) {
				swap(arr, high, i);
				high--;
			}
		}

	}
}
