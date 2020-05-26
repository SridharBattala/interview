package com.sree.programs.patterns.subsets;

import java.util.*;

class SubsetWithDuplicates {

	public static List<List<Integer>> findSubsets(int[] arr) {
		List<List<Integer>> subsets = new LinkedList<>();
		Arrays.sort(arr);
		subsets.add(new LinkedList<>());
		int startIndex = 0;
		int endIndex = subsets.size();
		for (int i = 0; i < arr.length; i++) {
			int currentSize = subsets.size();

			for (int j = startIndex; j < currentSize; j++) {
				List<Integer> list = new LinkedList<>();
				list.addAll(subsets.get(j));
				list.add(arr[i]);
				subsets.add(list);
			}
			if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
				startIndex = endIndex;
			}
			endIndex = subsets.size();
		}
		return subsets;
	}

	public static void main(String[] args) {

		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}
