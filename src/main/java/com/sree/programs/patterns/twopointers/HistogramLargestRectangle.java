package com.sree.programs.patterns.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * @author sbattala
 *
 */
public class HistogramLargestRectangle {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1 };
		int[] arr1 = new int[] { 2, 1, 5, 6, 2, 3 };

		// two pointers
		int startIndex = 0, endIndex = arr.length - 1;
		int maxArea = 0;
		while (startIndex < endIndex) {
			int currentArea = Math.min(arr[startIndex], arr[endIndex]) * (endIndex - startIndex);
			maxArea = Math.max(maxArea, currentArea);
			if (arr[startIndex] > arr[endIndex]) {
				endIndex--;
			} else {
				startIndex++;
			}
		}
		System.out.println("maxArea=" + maxArea);

	}
}
