package com.sree.programs.patterns.dpunboundedknapsack;

public class RodCutting {
	static int[] lengths = { 1, 2, 3, 4, 5 };
	static int[] prices = { 2, 6, 7, 10, 13 };
	static int rodLength = 5;

	// driver method
	public static void main(String args[]) {

		System.out.println("maxPrice=" + findMaxPriceTopDown(0, 0, 5));
		System.out.println("maxPrice=" + findMaxPriceBottomUp());
	}

	// recursive method
	public static int findMaxPriceTopDown(int currentIndex, int currentPrice, int currentRodLength) {
		// base case 1
		if (currentRodLength == 0 || currentIndex == prices.length) {
			return currentPrice;
		}
		// base case 2
		else if (currentRodLength < 0) {
			return 0;
		}
		// recursive case
		else {
			int price1 = findMaxPriceTopDown(currentIndex, currentPrice + prices[currentIndex],
					currentRodLength - lengths[currentIndex]);
			// System.out.println("price1=" + price1);
			int price2 = findMaxPriceTopDown(currentIndex + 1, currentPrice, currentRodLength);
			// System.out.println("price2=" + price2);
			return Math.max(price1, price2);

		}
	}

	public static int findMaxPriceBottomUp() {
		// define price 2D array
		int[][] dpArray = new int[lengths.length][rodLength + 1];
		// Initialize first column
		for (int i = 0; i < lengths.length; i++) {
			dpArray[i][0] = 0;
		}
		// Initialize first row
		for (int i = 1; i < rodLength + 1; i++) {
			dpArray[0][i] = i * prices[0];
		}
		// add remaining values
		for (int currentIndex = 1; currentIndex < lengths.length; currentIndex++) {
			for (int currentRodLength = 1; currentRodLength < rodLength + 1; currentRodLength++) {
				if (lengths[currentIndex] > currentRodLength) {
					dpArray[currentIndex][currentRodLength] = dpArray[currentIndex - 1][currentRodLength];
				} else {
					int price1 = dpArray[currentIndex - 1][currentRodLength];
					int price2 = prices[currentIndex] + dpArray[currentIndex][currentRodLength - lengths[currentIndex]];
					dpArray[currentIndex][currentRodLength] = Math.max(price1, price2);

				}

			}
		}
		return dpArray[lengths.length - 1][rodLength];
	}
}
