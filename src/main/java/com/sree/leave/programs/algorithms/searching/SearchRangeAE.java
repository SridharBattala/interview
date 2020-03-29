package com.sree.leave.programs.algorithms.searching;

/**
 * First and Last Indices of an Element in a Sorted Array Input: A =
 * [1,3,3,5,7,8,9,9,9,15], target = 9 Output: [6,8]
 */
public class SearchRangeAE {

	// O(log(n)) time | O(1) space
	public static int[] searchForRange(int[] array, int target) {
		int[] finalRange = { -1, -1 };
		alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
		alteredBinarySearch(array, target, 0, array.length - 1, finalRange, false);
		return finalRange;
	}

	public static void alteredBinarySearch(int[] array, int target, int left, int right, int[] finalRange,
			boolean goLeft) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] < target) {
				left = mid + 1;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				if (goLeft) {
					//mid=0 for [9,9,9,9,9]
					//array[mid - 1] != target for [3,2,9,9,9,9,9,1]
					if (mid == 0 || array[mid - 1] != target) {
						finalRange[0] = mid;
						return;
					} else {
						right = mid - 1;
					}
				} else {
					if (mid == array.length - 1 || array[mid + 1] != target) {
						finalRange[1] = mid;
						return;
					} else {
						left = mid + 1;
					}
				}
			}
		}
	}
}
