package com.sree.programs.important.leetcodetop75;

public class HouseRobberCircular {
	public static void main(String[] args) {

		int[] wealth = { 1, 2, 3, 1 };
		int[] wealth1 = { 2, 3, 2 };
		System.out.println(findMaxSteal(wealth));
		System.out.println("wealth1=" + findMaxSteal(wealth1));
	}

	private static int findMaxSteal(int[] input) {
		return findMaxStealRecursive(input, 0);

	}

	private static int findMaxStealRecursive(int[] input, int currentIndex) {
		if (currentIndex >= input.length) {
			return 0;
		} else {
			int amount1 = 0;
			if (currentIndex != input.length - 1) {
				amount1 = input[currentIndex] + findMaxStealRecursive(input, currentIndex + 2);

			}

			int amount2 = findMaxStealRecursive(input, currentIndex + 1);
			System.out.println("current index=" + currentIndex + ", max amout=" + Math.max(amount1, amount2));
			return Math.max(amount1, amount2);
		}
	}
}
