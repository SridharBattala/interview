package com.sree.programs.patterns.dppalindromicsubsequence;

import java.util.*;

class PalindromicPartitioning2 {

	public static void findMPPCuts(String st) {
		LinkedList<String> callStack = new LinkedList<>();
		LinkedList<LinkedList<String>> output = new LinkedList<>();
		findMPPCutsRecursive(st, 0, st.length() - 1, callStack, output);
		for (List<String> arr : output) {
			System.out.println("output=" + arr.toString());
		}
	}

	private static void findMPPCutsRecursive(String string, int startIndex, int endIndex, LinkedList<String> callStack,
			LinkedList<LinkedList<String>> output) {

		if (endIndex >= startIndex && isPalindrome(string, startIndex, endIndex)) {
			callStack.add(string.substring(startIndex, endIndex + 1));
			output.add(new LinkedList<>(callStack));
			callStack.removeLast();
			return;
		} else {

			for (int i = startIndex; i <= endIndex; i++) {
				if (isPalindrome(string, startIndex, i)) {
					callStack.add(string.substring(startIndex, i + 1));

					// LinkedList<String> temp = new LinkedList<>(callStack);
					System.out.println("call stack add=" + callStack.toString());

					findMPPCutsRecursive(string, i + 1, endIndex, callStack, output);
					callStack.removeLast();
					System.out.println("call stack remove=" + callStack.toString());
				}
			}
		}
	}

	private static boolean isPalindrome(String string, int startIndex, int endIndex) {
		while (endIndex >= startIndex) {
			if (string.charAt(startIndex) != string.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		return true;
	}

	public static void main(String[] args) {

		findMPPCuts("abdbca");
		// System.out.println(findMPPCuts("cdpdd"));
		// System.out.println(findMPPCuts("pqr"));
		// System.out.println(findMPPCuts("pp"));
	}
}
