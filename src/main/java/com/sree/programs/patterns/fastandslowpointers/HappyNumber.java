package com.sree.programs.patterns.fastandslowpointers;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM
 */
public class HappyNumber {
	public static void main(String args[]) {
		int number1 = 23;
		int number2 = 12;
		System.out.println("happy number= " + checkHappyNumber(number2));
	}

	private static boolean checkHappyNumber(int input) {
		int fast = input, slow = input;
		do {
			fast = squreNumber(squreNumber(fast));
			slow = squreNumber(slow);
		} while (slow != fast);
		return slow == 1;// check for happy number
	}

	private static int squreNumber(int input) {
		int sum = 0;
		while (input > 0) {

			sum = sum + ((input % 10) * (input % 10));
			input = input / 10;
		}
		return sum;
	}
}
