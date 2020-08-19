package com.sree.programs.important.askedininterviews;

import java.util.*;

public class LivePairSort {
	public static void main(String[] args) {
		int arr[] = { 1, -1, 3, 2, -2, -3, 7, -7, -1, 1 };
		int[] output = pairSort(arr);
		System.out.println("ouput" + Arrays.toString(output));
	}

	private static int[] pairSort(int[] arr) {
		// define heap
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
		// add elements to heap
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] >= 0) {
				heap.offer(arr[index]);
			} else {
				heap.offer(0 - arr[index]);
			}

		}
		int index = 0;
		boolean negative = true;
		while (!heap.isEmpty()) {
			if (negative) {
				arr[index] = 0 - heap.poll();
				negative = false;
			} else {
				arr[index] = heap.poll();
				negative = true;
			}
			index++;
		}
		return arr;
	}
}
