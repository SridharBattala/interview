package com.sree.programs.datastructures.arrays;

import java.util.*;

public class FindDuplicates {
	private static int[] findDuplicates(int[] arr1, int[] arr2) {
		List<Integer> output = new ArrayList<>();
		int arr1Index = 0, arr2Index = 0;
		while (arr1Index < arr1.length && arr2Index < arr2.length) {
			if (arr1[arr1Index] == arr2[arr2Index]) {
				output.add(arr1[arr1Index]);
				arr1Index++;
			} else if (arr1[arr1Index] > arr2[arr2Index]) {
				arr2Index++;
			} else {
				arr1Index++;
			}

		}
		int[] outputArr = new int[output.size()];
		int index = 0;
		for (Integer value : output) {
			outputArr[index] = value;
			index++;
		}
		return outputArr;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 5, 6, 7 };
		int[] arr2 = { 3, 6, 7, 8, 20 };
		int[] output = findDuplicates(arr1, arr2);
		System.out.println(Arrays.toString(output));
	}

}
