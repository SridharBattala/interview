package com.sree.programs.algorithms.sorting;

import java.util.Arrays;

/**
 * https://outco.teachable.com/courses/438359/lectures/6721855
 * 
 * @author sbattala
 *
 */
class QuickSortOutcoLecture {

	private static void divide(int[] input, int start, int end) {
		// base case
		if (start >= end) {
			return;
		}
		// recursive case
		else {
			//every time take starting element as pivot
			int pivot = start;
			int needToSwap=start+1;
			for (int current = start+1; current <= end; current++) {
				//check pivot is great than current
				if (input[pivot] > input[current]) {
					swap(input,needToSwap,current);
					needToSwap++;
				}
			}
			//swap pivot with need to swap
			swap(input, pivot, needToSwap-1);
			pivot=needToSwap-1;
			System.out.println("current="+Arrays.toString(input));
			divide(input, start, pivot - 1);
			divide(input, pivot + 1, end);
		}
	}
	public static void main(String[] args) {
		int[] input = { 8, 14, 12, 5, 15, 9, 2, 11, 17, 1,10,4,7,13,6 };
		System.out.println(Arrays.toString(input));
		System.out.println();
		divide(input, 0, input.length - 1);
		System.out.println();
		System.out.println(Arrays.toString(input));

	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
