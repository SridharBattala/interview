package com.sree.programs.datastructures.strings;

public class PrintAllSubstrings {
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

		printAllSubstringsRecursive(input, 0, input.length() - 1);

	}

	private static void printAllSubstringsRecursive(String input, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return;
		} else {
			for (int index = startIndex; index <= endIndex; index++) {
				System.out.println(input.substring(startIndex, index + 1));
				printAllSubstringsRecursive(input, startIndex + 1, endIndex);
			}

		}
	}
}
