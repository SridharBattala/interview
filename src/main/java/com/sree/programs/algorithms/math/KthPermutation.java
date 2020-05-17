package com.sree.programs.algorithms.math;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
	public static void main(String args[]) {

		String result = findPermutation(4, 8);
		System.out.println("result=" + result);
	}

	private static String findPermutation(int inputEndNumber, int j) {
		List<Integer> inputList = new ArrayList<>();
		for (int i = 1; i <= inputEndNumber; i++) {
			inputList.add(i);
		}
		StringBuilder result = new StringBuilder();
		findKthPermutation(inputList, j, result);
		return result.toString();
	}

	private static void findKthPermutation(List<Integer> inputList, int position, StringBuilder result) {

		if (inputList.isEmpty()) {
			return;
		} else {

			int totalPermutations = factorial(inputList.size() - 1);
			int selectedIndex = (position - 1) / totalPermutations;
			result = result.append(inputList.get(selectedIndex) + "");
			inputList.remove(selectedIndex);
			position = position - (totalPermutations * selectedIndex);
			findKthPermutation(inputList, position, result);

		}

	}

	static int factorial(int n) {
		// base case
		if (n == 0 || n == 1) {
			return 1;
		}
		// recursive case
		else {
			return n * factorial(n - 1);
		}

	}
}
