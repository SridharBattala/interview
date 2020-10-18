package com.sree.programs.algorithms.kadanes;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
import java.util.*;

class StockBuySell4 {
	static int transactionCount = 0;
	static int totalProfit = 0;
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

	public static void buySellStocks(int[] prices) {
		LinkedList<Integer> callStack = new LinkedList<>();
		LinkedList<LinkedList<Integer>> output = new LinkedList<>();
		int maxTransactions = 2;
		buySellStocksRecursive(prices, 0, callStack, output, maxTransactions);
		System.out.println("output=");
		for (LinkedList<Integer> list : output) {
			System.out.println(list.toString());
		}

		System.out.println("maxHeap=" + maxHeap.toString());
		for (int i = 0; i < maxTransactions; i++) {
			totalProfit = totalProfit + maxHeap.poll();
		}
		System.out.println("totalProfit=" + totalProfit);
	}

	private static void buySellStocksRecursive(int[] prices, int index, LinkedList<Integer> callStack,
			LinkedList<LinkedList<Integer>> output, int maxTransactions) {
		if (callStack.size() == 2) {
			maxHeap.add(callStack.get(1) - callStack.get(0));
			output.add(new LinkedList<Integer>(callStack));
			return;
		} else if (index == prices.length) {
			return;
		} else {

			callStack.add(prices[index]);
			System.out.println("call stack=" + callStack.toString());
			buySellStocksRecursive(prices, index + 1, callStack, output, maxTransactions);
			callStack.removeLast();

			buySellStocksRecursive(prices, index + 1, callStack, output, maxTransactions);
		}
	}

	public static void main(String[] args) {
		int[] array = { 3, 2, 6, 5, 0, 3 };
		buySellStocks(array);
	}
}
