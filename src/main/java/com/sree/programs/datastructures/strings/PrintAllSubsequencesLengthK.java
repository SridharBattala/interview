package com.sree.programs.datastructures.strings;

public class PrintAllSubsequencesLengthK {
	public static void main(String[] args) {
		printAllSubsequences("abc");
	}

	// driver method
	private static void printAllSubsequences(String input) {

		printAllSubsequencesRecursive(input, "", 0);
	}

	private static void printAllSubsequencesRecursive(String input, String currentString, int index) {
		if (currentString.length() == 2) {
			System.out.println(currentString);
			return;

		} else if (index > input.length() - 1) {
			return;
		} else {
			// System.out.println(currentString);
			printAllSubsequencesRecursive(input, currentString + input.charAt(index), index + 1);

			printAllSubsequencesRecursive(input, currentString, index + 1);
		}
	}
}
