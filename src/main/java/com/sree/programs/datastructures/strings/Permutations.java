package com.sree.programs.datastructures.strings;

import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		getPermutations("abc");
	}

	// driver method
	// define start, end and start=0 and end always string length
	// increase start by 1 every loop
	// in each after every loop make one character as constant
	// print all the elements when start =end
	private static void getPermutations(String string) {

		getPermutationsRecursive(string.toCharArray(), 0, string.length() - 1);
	}

	private static void getPermutationsRecursive(char[] input, int start, int end) {
		if (start == end) {
			System.out.println(input);
		} else {
			for (int i = start; i <= end; i++) {
				swap(input, start, i);
				getPermutationsRecursive(input, start + 1, end);
				// back tracking
				swap(input, start, i);
			}

		}

	}

	private static void swap(char[] input, int i, int j) {

		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
