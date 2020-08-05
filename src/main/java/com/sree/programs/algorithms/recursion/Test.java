package com.sree.programs.algorithms.recursion;

public class Test {
	public static void main(String args[]) {

		print(1, 10);
		System.out.println("=====");
		printRecursive(1, 10);
	}

	private static void print(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println(i);
		}

	}
//driver method

//recursive method
//-- base case
//-- recursive case

//driver method
	private static void printRecursive(int start, int end) {

		helper(start, end);
	}

	private static void helper(int start, int end) {
		// base case
		if (start > end) {
			return;
		}
		// recursive case
		else {

			helper(start + 1, end);
			System.out.println(start);
		}
	}

}
