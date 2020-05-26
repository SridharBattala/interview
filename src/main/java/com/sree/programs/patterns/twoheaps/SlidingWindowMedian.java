package com.sree.programs.patterns.twoheaps;

import java.util.*;

public class SlidingWindowMedian {
	public static void main(String[] args) {

		List<Double> result = findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
	}

	private static List<Double> findSlidingWindowMedian(int[] arr, int windowSize) {
		List<Double> output = new LinkedList<>();
		// base case
		if (arr.length == 0) {
			return output;
		}
		// define heaps
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		// loop input arr
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= arr[windowEnd]) {
				maxHeap.add(arr[windowEnd]);
			} else {
				minHeap.add(arr[windowEnd]);
			}
			// rebalance heaps
			rebalanceHeap(maxHeap, minHeap);
			// check for window size
			int currentWindowSize = windowEnd - windowStart + 1;
			if (currentWindowSize == windowSize) {
				// calculate median
				Double median = null;
				if (maxHeap.size() == minHeap.size()) {
					median = (maxHeap.peek() + minHeap.peek()) / 2.0;
				} else {
					median = maxHeap.peek().doubleValue();
				}
				output.add(median);
				// remove window start element
				if (maxHeap.peek() >= arr[windowStart]) {
					maxHeap.remove(arr[windowStart]);
				} else {
					minHeap.remove(arr[windowStart]);
				}
				windowStart = windowStart + 1;
				// rebalance heaps
				rebalanceHeap(maxHeap, minHeap);
			}
		}
		return output;
	}

	public static void rebalanceHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}
}
