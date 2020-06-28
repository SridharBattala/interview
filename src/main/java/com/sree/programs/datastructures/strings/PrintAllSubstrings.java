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
		for (int i = 0; i < input.length(); i++) {
			printAllSubstringsRecursive(input, "", i);
		}
	}

	private static boolean printAllSubstringsRecursive(String input, String currentString, int index) {
		if (index > input.length() - 1) {
			System.out.println(currentString);
			return true;

		} else {
			if (!currentString.isEmpty()) {
				System.out.println(currentString);
			}

			printAllSubstringsRecursive(input, currentString + input.charAt(index), index + 1);

			// printAllSubstringsRecursive(input, currentString, index + 1);
			return true;
		}
	}
}
