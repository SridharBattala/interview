package com.sree.programs.datastructures.strings;

public class PrintAllSubsequencesCount {
	public static void main(String[] args) {
		int output = printAllSubsequences("abc");
		System.out.println("output=" + output);
	}

	// driver method
	private static int printAllSubsequences(String input) {

		return printAllSubsequencesRecursive(input, "", 0);
	}

	private static int printAllSubsequencesRecursive(String input, String currentString, int index) {
		if (index == input.length()) {

			return 1;

		} else {
			// System.out.println(currentString);
			return printAllSubsequencesRecursive(input, currentString + input.charAt(index), index + 1) +

					printAllSubsequencesRecursive(input, currentString, index + 1);
		}
	}
}
