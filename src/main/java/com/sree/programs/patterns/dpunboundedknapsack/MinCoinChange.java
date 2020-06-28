package com.sree.programs.patterns.dpunboundedknapsack;

import java.util.*;

class MinCoinChange {

	public int countChange(int[] denominations, int total) {
		List<Integer> currentStack = new LinkedList<>();
		int min = countChangeRecursive(denominations, total, 0, currentStack);
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;

	}

	private static int countChangeRecursive(int[] denominations, int total, int currentIndex,
			List<Integer> currentStack) {
		// base check
		if (total == 0) {
			// System.out.println(currentStack);
			return currentStack.size();
		} else if (denominations.length == 0 || currentIndex > denominations.length - 1 || total < 0) {
			return Integer.MAX_VALUE;
		}

		else {

			currentStack.add(denominations[currentIndex]);
			int currentStackLength1 = countChangeRecursive(denominations, total - denominations[currentIndex],
					currentIndex, currentStack);
			currentStack.remove(currentStack.size() - 1);

			// recursive call after excluding the coin at the currentIndex
			int currentStackLength2 = countChangeRecursive(denominations, total, currentIndex + 1, currentStack);
			// take min
			return Math.min(currentStackLength1, currentStackLength2);
		}

	}

	public static void main(String[] args) {
		MinCoinChange cc = new MinCoinChange();
		int[] denominations = { 1, 2, 3 };
		System.out.println(cc.countChange(denominations, 5));
		System.out.println(cc.countChange(denominations, 11));
		System.out.println(cc.countChange(denominations, 7));
		denominations = new int[] { 3, 5 };
		System.out.println(cc.countChange(denominations, 7));
	}
}
