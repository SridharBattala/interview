package com.sree.programs.patterns.cyclicsort;

import java.util.*;

public class AllDuplicateNumbers {
	public static void main(String[] args) {
		List<Integer> duplicates = findNumbers(new int[] { 3, 4, 4, 5, 5 });
		System.out.println("Duplicates are: " + duplicates);
	}

	private static List<Integer> findNumbers(int[] arr) {
		List<Integer> output = new LinkedList<>();
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != arr[arr[i] - 1]) {
				swap(arr, i, arr[i] - 1);
			} else {
				i++;
			}
		}
		// add duplicates to output
		for (i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				output.add(arr[i]);
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
