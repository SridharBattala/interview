package com.sree.programs.patterns.dpunboundedknapsack;

import java.util.*;

class CoinChange {

	public int countChange(int[] denominations, int total) {
		List<Integer> currentStack = new LinkedList<>();
		return countChangeRecursive(denominations, total, 0);

	}

	private static int countChangeRecursive(int[] denominations, int total, int currentIndex) {
		// base check
		if (total == 0) {
			return 1;
		} else if (denominations.length == 0 || currentIndex >= denominations.length) {
			return 0;
		}

		else {
			int count1 = 0;
			if (denominations[currentIndex] <= total) {
				count1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);

			}
			// recursive call after excluding the coin at the currentIndex
			int count2 = countChangeRecursive(denominations, total, currentIndex + 1);
			return count1 + count2;
		}

	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] denominations = { 1, 2, 3 };
		System.out.println(cc.countChange(denominations, 5));
		// System.out.println(cc.countChange(denominations, 11));
		// System.out.println(cc.countChange(denominations, 7));
		// denominations = new int[] { 3, 5 };
		// System.out.println(cc.countChange(denominations, 7));
	}
}
