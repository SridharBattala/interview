package com.sree.programs.algorithms.recursion;

public class Palindrome {
	public static void main(String args[]) {
		System.out.println(checkPalindrome("madam"));
		System.out.println(checkPalindrome("madeam"));
	}

	private static boolean checkPalindrome(String input) {

		return checkPalindromeDriver(input);
	}

	// driver method
	private static boolean checkPalindromeDriver(String input) {

		return checkPalindromeRecursive(input, 0, input.length() - 1);
	}

	// recursive method
	private static boolean checkPalindromeRecursive(String input, int startIndex, int endIndex) {

		if (startIndex == endIndex || startIndex > endIndex) {
			return true;
		} else {
			if (input.charAt(startIndex) == input.charAt(endIndex)) {
				return checkPalindromeRecursive(input, startIndex + 1, endIndex - 1);
			} else {
				return false;
			}
		}
	}
}
