package com.sree.programs.algorithms.greedy;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/gx6oKY8PGYY
 * 
 * @author sbattala
 *
 */
import java.util.*;

public class MaximumDistinctElements {
	public static int findMaximumDistinctElements(int[] nums, int k) {
		// create frequency map
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int index = 0; index < nums.length; index++) {
			freqMap.put(nums[index], freqMap.getOrDefault(nums[index], 0) + 1);
		}
		int distinctCount = 0;
		// prepare min heap
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() == 1) {
				distinctCount++;
			} else {
				minHeap.add(entry);
			}
		}
		// loop min heap
		while (!minHeap.isEmpty()) {
			Map.Entry<Integer, Integer> entry = minHeap.poll();
			int freqValue = entry.getValue();
			while (freqValue != 1 && k > 0) {
				freqValue--;
				k--;
			}
			if (freqValue == 1) {
				distinctCount++;
			}

		}
		while (k > 0) {
			distinctCount--;
			k--;
		}
		return distinctCount;
	}

	public static void main(String[] args) {
		int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);
	}
}
