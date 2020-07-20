package com.sree.programs.algorithms.recursion;

public class ElementOccurrencesCount {
	static int target = 3;

	public static void main(String args[]) {
		int[] array = { 2, 3, 4, 1, 7, 8, 3 };
		System.out.println(getCountDriver(array));

	}

	// driver method
	private static int getCountDriver(int[] input) {

		return getCountRecursive1(input, 0);
	}

	// recursive method
	private static int getCountRecursive1(int[] input, int index) {

		if (index == input.length) {
			return 0;
		} else {
			if (input[index] == target) {
				return 1 + getCountRecursive1(input, index + 1);
			} else {
				return getCountRecursive1(input, index + 1);
			}

		}
	}

	// recursive method
	private static int getCountRecursive(int[] input, int index, int count) {

		if (index == input.length) {
			return count;
		} else {
			if (input[index] == target) {
				count = count + 1;
			}
			return getCountRecursive(input, index + 1, count);
		}
	}
}
