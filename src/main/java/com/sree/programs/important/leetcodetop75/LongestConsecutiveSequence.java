package com.sree.programs.important.leetcodetop75;

import java.util.*;

public class LongestConsecutiveSequence {
	public static void main(String args[]) {
		int[] arr = { 100, 4, 200, 1, 3, 2 };
		System.out.println("count=" + longestConsecutive(arr));

	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}

		int globalLength = 0;

		for (int num : set) {
			if (!set.contains(num - 1)) {
				int currentNum = num;
				int currentLength = 1;

				while (set.contains(currentNum + 1)) {
					currentNum = currentNum + 1;
					currentLength = currentLength + 1;
				}
				System.out.println("num=" + num + ", currentLength=" + currentLength);
				globalLength = Math.max(globalLength, currentLength);
			}
		}

		return globalLength;
	}
}
