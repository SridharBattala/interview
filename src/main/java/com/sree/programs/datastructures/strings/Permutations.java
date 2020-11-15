package com.sree.programs.datastructures.strings;

import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		List<String> output = getPermutations("abc");
		System.out.println("output=" + output.toString());
	}

	// driver method
	// define start, end and start=0 and end always string length
	// increase start by 1 every loop
	// in each after every loop make one character as constant
	// print all the elements when start =end
	private static List<String> getPermutations(String string) {
		List<String> callStack = new LinkedList<>();
		getPermutationsRecursive(string.toCharArray(), 0, callStack);
		return callStack;
	}

	private static void getPermutationsRecursive(char[] input, int currentIndex, List<String> callStack) {
		if (currentIndex == input.length - 1) {
			callStack.add(new String(input));
			return;
		} else {
			for (int i = currentIndex; i <= input.length - 1; i++) {
				swap(input, currentIndex, i);
				getPermutationsRecursive(input, currentIndex + 1, callStack);
				// back tracking
				swap(input, currentIndex, i);
			}

		}

	}

	private static void swap(char[] input, int i, int j) {

		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
