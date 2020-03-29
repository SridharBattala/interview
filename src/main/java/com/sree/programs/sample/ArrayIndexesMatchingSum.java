package com.sree.leave.programs.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayIndexesMatchingSum {
	private static void findNumberSumIndexs(int[] arr, int num) {
		for (int m = 0; m < arr.length; m++) {
			findIndexes(Arrays.copyOfRange(arr, m, arr.length), num, m);
		}
	}
	private static void findIndexes(int[] arr, int num, int index) {
		for (int i = 0; i < arr.length; i++) {
			List<Integer> finalList = new ArrayList<>();
			for (int k = i; k >= 0; k--) {
				finalList.add(k);
			}
			for (int j = i + 1; j < arr.length; j++) {
				int sum = 0;
				for (int n : finalList) {
					sum = sum + arr[n];
				}
				sum = sum + arr[j];
				if (sum == num) {
					finalList.add(j);
					System.out.println(
							finalList.stream().map(value -> value = value + index).collect(Collectors.toList()));
				} else {
					continue;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, -1, 2, 3, 1, -1 };
		findNumberSumIndexs(arr, 2);
	}
}
