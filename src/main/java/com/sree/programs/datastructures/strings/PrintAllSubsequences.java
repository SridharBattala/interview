package com.sree.programs.datastructures.strings;

public class PrintAllSubsequences {
	public static void main(String[] args) {
		printAllSubsequences("abc");
	}

	// driver method
	private static void printAllSubsequences(String input) {

		printAllSubsequencesRecursive(input, "", 0);
	}

	private static void printAllSubsequencesRecursive(String input, String currentString, int index) {
		if (index == input.length()) {
			System.out.println(currentString);
			return;

		} else {
			// System.out.println(currentString);
			printAllSubsequencesRecursive(input, currentString + input.charAt(index), index + 1);

			printAllSubsequencesRecursive(input, currentString, index + 1);
		}
	}
}
