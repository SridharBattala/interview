package com.sree.programs.patterns.cyclicsort;

import java.util.*;

public class AllMissingNumbers {
	public static void main(String[] args) {
		List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
		System.out.println("Missing numbers: " + missing);
	}

	private static List<Integer> findNumbers(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != arr[arr[i] - 1]) {
				swap(arr, i, arr[i] - 1);
			} else {
				i++;
			}
		}
		List<Integer> output = new LinkedList<>();
		for (i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				output.add(i + 1);
			}
		}
		return output;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
