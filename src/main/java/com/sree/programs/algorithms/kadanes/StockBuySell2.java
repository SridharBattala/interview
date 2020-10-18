package com.sree.programs.algorithms.kadanes;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

class StockBuySell2 {
	public static int findBuySellStockPrices(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxprofit = maxprofit + (prices[i] - prices[i - 1]);
			}
			System.out.println("element=" + prices[i] + ", maxprofit=" + maxprofit);
		}
		return maxprofit;
	}

	public static void main(String[] args) {
		int[] array = { 7, 1, 5, 6, 3, 7, 8 };
		System.out.println("max profilt=" + findBuySellStockPrices(array));
	}
}
