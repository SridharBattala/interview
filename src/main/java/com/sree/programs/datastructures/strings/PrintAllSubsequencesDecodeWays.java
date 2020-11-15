package com.sree.programs.datastructures.strings;

import java.util.LinkedList;

public class PrintAllSubsequencesDecodeWays {
	public static void main(String[] args) {
		printAllSubsequences("123");
	}

	// driver method
	private static void printAllSubsequences(String input) {
		LinkedList<String> callStack = new LinkedList<>();
		printAllSubsequencesRecursive(input, callStack, 0);
	}

	private static void printAllSubsequencesRecursive(String input, LinkedList<String> callStack, int index) {
		if (index == input.length()) {
			System.out.println("callStack=" + callStack.toString());
			return;

		} else {
			// System.out.println(currentString);
			callStack.add(Character.toString(input.charAt(index)));
			printAllSubsequencesRecursive(input, callStack, index + 1);
			callStack.removeLast();
			if (index + 2 <= input.length()) {
				callStack.add(Character.toString(input.charAt(index)) + Character.toString(input.charAt(index + 1)));
				printAllSubsequencesRecursive(input, callStack, index + 2);
				callStack.removeLast();
			}

		}
	}
}
