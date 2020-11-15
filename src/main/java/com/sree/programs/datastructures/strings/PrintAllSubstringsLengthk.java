package com.sree.programs.datastructures.strings;

public class PrintAllSubstringsLengthk {
	public static void main(String[] args) {
		// printAllSubstringsIteration("abcd");
		printAllSubstrings("abcd");
	}

	private static void printAllSubstringsIteration(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j < input.length(); j++) {
				System.out.println(input.substring(i, j + 1));
			}
		}

	}

	// driver method
	private static void printAllSubstrings(String input) {

		printAllSubstringsRecursive(input, 0, "");

	}

	private static void printAllSubstringsRecursive(String input, int index, String currentString) {
		if (index > input.length() - 1) {
			return;
		} else {

			for (int i = index; i <= input.length() - 1; i++) {
				System.out.println(input.substring(index, i + 1));
			}
			printAllSubstringsRecursive(input, index + 1, currentString);

		}
	}
}
