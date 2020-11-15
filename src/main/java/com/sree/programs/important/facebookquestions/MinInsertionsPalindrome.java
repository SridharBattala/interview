package com.sree.programs.important.facebookquestions;

/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * 
 * @author sbattala
 *
 */
public class MinInsertionsPalindrome {
	// Recursive function to find minimum number
	// of insertions
	static int findMinInsertions(char str[], int startIndex, int endIndex) {
		// Base Cases
		if (startIndex > endIndex)
			return Integer.MAX_VALUE;
		if (startIndex == endIndex)
			return 0;

		// Check if the first and last characters
		// are same. On the basis of the comparison
		// result, decide which subrpoblem(s) to call
		int minCount = Integer.MAX_VALUE;
		if (str[startIndex] == str[endIndex]) {
			minCount = findMinInsertions(str, startIndex + 1, endIndex - 1);
		} else {
			minCount = 1 + Math.min(findMinInsertions(str, startIndex, endIndex - 1),
					findMinInsertions(str, startIndex + 1, endIndex));
		}
		return minCount;
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		String str1 = "mbadm";
		String str2 = "leetcode";

		System.out.println("Min insertions=" + findMinInsertions(str2.toCharArray(), 0, str2.length() - 1));
	}
}
