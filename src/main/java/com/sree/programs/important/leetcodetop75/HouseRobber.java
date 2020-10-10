package com.sree.programs.important.leetcodetop75;

public class HouseRobber {
	public static void main(String[] args) {

		int[] wealth = { 2, 5, 1, 3, 6, 2, 4 };
		System.out.println(findMaxSteal(wealth));

	}

	private static int findMaxSteal(int[] input) {
		return findMaxStealRecursive(input, 0);

	}

	private static int findMaxStealRecursive(int[] input, int currentIndex) {
		if (currentIndex >= input.length) {
			return 0;
		} else {

			int amount1 = input[currentIndex] + findMaxStealRecursive(input, currentIndex + 2);

			int amount2 = findMaxStealRecursive(input, currentIndex + 1);
			System.out.println("current index=" + currentIndex + ", max amout=" + Math.max(amount1, amount2));
			return Math.max(amount1, amount2);
		}
	}
}
