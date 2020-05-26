package com.sree.programs.patterns.topkelements;

import java.util.*;

class KthSmallestNumber {

	public static int findKthSmallestNumber(int[] nums, int k) {
		// max heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		// base case
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < k; i++) {
			maxHeap.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (maxHeap.peek() > nums[i]) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
		System.out.println("Kth smallest number is: " + result);

		// since there are two 5s in the input array, our 3rd and 4th smallest numbers
		// should be a '5'
		result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
		System.out.println("Kth smallest number is: " + result);

		result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);
	}
}
