package com.sree.programs.algorithms.dynamicprogramming;

public class EditDistance {
	public static void main(String[] args) {
		int distance = findEditDistance("sridhar", "sree");
		System.out.println("Edit distance=" + distance);
	}

	//driver method
	private static int findEditDistance(String string1, String string2) {

		return helper(string1, string2, 0, 0);
	}

	//driver method
	private static int findEditDistanceTopDown(String string1, String string2) {
		Integer[][] dp = new Integer[string1.length() + 1][string2.length() + 1];
		return topDownHelper(string1, string2, 0, 0, dp);
	}

	//top Down Helper method
	private static int topDownHelper(String string1, String string2, int i1, int i2, Integer[][] dp) {
		if (dp[i1][i2] == null) {
			// base case 1
			// if we have reached the end of s1, then we have to insert all the remaining
			// characters of s2
			if (string1.length() == i1) {
				return string2.length() - i2;
			}
			// base case 2
			// if we have reached the end of s2, then we have to delete all the remaining
			// characters of s1
			else if (string2.length() == i2) {
				return string1.length() - i1;
			}
			// recursive case
			else {
				if (string1.charAt(i1) == string2.charAt(i2)) {
					return helper(string1, string2, i1 + 1, i2 + 1);
				}
				int count1 = 1 + helper(string1, string2, i1 + 1, i2);// perform deletion
				int count2 = 1 + helper(string1, string2, i1 + 1, i2);// perform insertion
				int count3 = 1 + helper(string1, string2, i1 + 1, i2 + 1);// perform insertion
				int count = Math.min(count1, Math.min(count2, count3));
				return count;
			}
		}
		return dp[i1][i2];

	}

//helper method
	private static int helper(String string1, String string2, int i1, int i2) {
		// base case 1
		// if we have reached the end of s1, then we have to insert all the remaining
		// characters of s2
		if (string1.length() == i1) {
			return string2.length() - i2;
		}
		// base case 2
		// if we have reached the end of s2, then we have to delete all the remaining
		// characters of s1
		else if (string2.length() == i2) {
			return string1.length() - i1;
		}
		// recursive case
		else {
			if (string1.charAt(i1) == string2.charAt(i2)) {
				return helper(string1, string2, i1 + 1, i2 + 1);
			}
			int count1 = 1 + helper(string1, string2, i1 + 1, i2);// perform deletion
			int count2 = 1 + helper(string1, string2, i1 + 1, i2);// perform insertion
			int count3 = 1 + helper(string1, string2, i1 + 1, i2 + 1);// perform insertion
			int count = Math.min(count1, Math.min(count2, count3));
			return count;
		}

	}

}
