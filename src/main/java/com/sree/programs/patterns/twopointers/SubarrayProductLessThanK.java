package com.sree.programs.patterns.twopointers;

import java.util.*;

public class SubarrayProductLessThanK {
	public static void main(String[] args) {
		System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
	}

	public static List<List<Integer>> findSubarrays(int[] input, int target) {
		List<List<Integer>> subarrays = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			int product = 1;
			for (int j = i; j < input.length; j++) {
				product = product * input[j];
				if (target > product) {
					List<Integer> list = new LinkedList<>();
					for (int k = i; k <= j; k++) {

						list.add(input[k]);
					}
					subarrays.add(list);

				}
			}
		}
		return subarrays;
	}
}
