package com.sree.programs.patterns.modifiedbinarysearch;

public class NextLetter {

	public static void main(String[] args) {
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}

	private static char searchNextLetter(char[] input, char targetChar) {
		// base case
		int length = input.length;
		if (targetChar < input[0] || targetChar > input[length - 1]) {
			return input[0];
		}
		// binary search
		int start = 0;
		int end = input.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (targetChar < input[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return input[start % input.length];
	}
}
