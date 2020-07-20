package com.sree.programs.patterns.dplongestcommonsubstring;

public class LongestBitonicSubsequence {
	public static void main(String[] args) {

		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(findLBSLength(nums));
		nums = new int[] { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
		System.out.println(findLBSLength(nums));
	}

	private static int findLBSLength(int[] nums) {
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			int c1 = findLDSLength(nums, i, -1);
			int c2 = findLDSLengthRev(nums, i, -1);
			maxLength = Math.max(maxLength, c1 + c2 - 1);
		}
		return maxLength;
	}

	private static int findLDSLengthRev(int[] nums, int currentIndex, int previousIndex) {
		if (currentIndex < 0) {
			return 0;
		} else {
			int count1 = 0;
			if (previousIndex == -1 || nums[currentIndex] < nums[previousIndex]) {
				count1 = 1 + findLDSLengthRev(nums, currentIndex - 1, currentIndex);
			}
			int count2 = findLDSLengthRev(nums, currentIndex - 1, previousIndex);
			return Math.max(count1, count2);
		}
	}

	private static int findLDSLength(int[] nums, int currentIndex, int previousIndex) {
		if (currentIndex == nums.length) {
			return 0;
		} else {
			int count1 = 0;
			if (previousIndex == -1 || nums[currentIndex] < nums[previousIndex]) {
				count1 = 1 + findLDSLength(nums, currentIndex + 1, currentIndex);
			}
			int count2 = findLDSLength(nums, currentIndex + 1, previousIndex);
			return Math.max(count1, count2);
		}
	}

}
