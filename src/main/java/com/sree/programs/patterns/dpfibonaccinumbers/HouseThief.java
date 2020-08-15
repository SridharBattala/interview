package com.sree.programs.patterns.dpfibonaccinumbers;

//package whatever; // don't place package name!

import java.io.*;

//Input: {2, 5, 1, 3, 6, 2, 4}
//Output: 15
//Explanation: The thief should steal from houses 5 + 6 + 4
class HouseThief {
	public static void main(String[] args) {
		int[] input = { 2, 5, 1, 3, 6, 2, 4 };
		int output = maximizeStealing(input);
		System.out.println("output=" + output);
	}

//diver method
	public static int maximizeStealing(int[] input) {
		return maximizeStealingRecursive(input, 0);
	}

//recursive method
	public static int maximizeStealingRecursive(int[] input, int index) {
		if (index >= input.length) {
			return 0;
		} else {
			int count1 = input[index] + maximizeStealingRecursive(input, index + 2);
			int count2 = maximizeStealingRecursive(input, index + 1);
			System.out.println("count1=" + count1 + ", count2=" + count2);
			return Math.max(count1, count2);
		}
	}
}
