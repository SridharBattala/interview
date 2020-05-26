package com.sree.programs.patterns.dplongestcommonsubstring;

import java.util.*;

/**
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQ0y0QOJQ69
 * 
 * @author sbattala
 *
 */
public class LongestIncreasingSubsequence {
	static Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) {

		int[] arr = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println("length=" + findLISLength(arr));
		cache.clear();
		arr = new int[] { -4, 10, 3, 7, 15 };
		System.out.println("length=" + findLISLength(arr));
	}

	// driver method
	private static int findLISLength(int[] arr) {
		return findLISLengthRecursive(arr, 0, -1);
	}

	// recursive method
	private static int findLISLengthRecursive(int[] arr, int currentIndex, int previousIndex) {
		// base case
		if (arr.length == currentIndex) {
			return 0;
		}
		// recursive case
		else {
			if (cache.containsKey(currentIndex + "|" + previousIndex)) {
				return cache.get(currentIndex + "|" + previousIndex);
			} else {
				int count1 = 0;
				if (previousIndex == -1 || arr[currentIndex] > arr[previousIndex]) {
					count1 = 1 + findLISLengthRecursive(arr, currentIndex + 1, currentIndex);
				}
				int count2 = findLISLengthRecursive(arr, currentIndex + 1, previousIndex);
				int count = Math.max(count1, count2);
				cache.put(currentIndex + "|" + previousIndex, count);
				return count;
			}
		}

	}
}
