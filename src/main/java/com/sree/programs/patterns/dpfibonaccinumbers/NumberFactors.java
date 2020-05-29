package com.sree.programs.patterns.dpfibonaccinumbers;

import java.util.*;;

public class NumberFactors {
	static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String args[]) {
		System.out.println("numberOfWays=" + findWaysTopDown(5));
		System.out.println("numberOfWays=" + findWaysBottomUp(5));
	}

	private static int findWaysTopDown(int currentNum) {
		// base case 1
		if (currentNum == 0) {

			return 1;
		}
		// base case 2
		else if (currentNum < 0) {
			return 0;
		}
		// recursive case
		else {
			if (cache.containsKey(currentNum)) {
				return cache.get(currentNum);
			} else {
				int numberOfWays = findWaysTopDown(currentNum - 1) + findWaysTopDown(currentNum - 3)
						+ findWaysTopDown(currentNum - 4);
				cache.put(currentNum, numberOfWays);
				return numberOfWays;
			}

		}

	}

	private static int findWaysBottomUp(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		for (int index = 4; index < dp.length; index++) {
			dp[index] = dp[index - 1] + dp[index - 3] + dp[index - 4];
		}
		return dp[num];
	}
}
