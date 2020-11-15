package com.sree.programs.algorithms.backtracking;

import java.util.*;

public class CommonSubstrings {
	static Map<String, List<String>> cache = new HashMap<>();

	public static void main(String[] args) {
		String s1 = "sreeabc";
		String s2 = "reabc";
		printCommonSubstrings(s1, s2);
	}

	private static void printCommonSubstrings(String s1, String s2) {

		helper(s1, s2, 0, 0, "");
		System.out.println(cache.toString());
	}

	private static void helper(String s1, String s2, int index1, int index2, String callStack) {
		if (index1 == s1.length() || index2 == s2.length()) {
			// System.out.println("call stack=" + callStack.toString());

			cache.getOrDefault(index1 + "|" + index2, new LinkedList<>()).add(callStack);
			return;
		} else {
			if (s1.charAt(index1) == s2.charAt(index2)) {

				helper(s1, s2, index1 + 1, index2 + 1, callStack + s1.charAt(index1));

			}

			helper(s1, s2, index1 + 1, index2, "");

			helper(s1, s2, index1, index2 + 1, "");
		}

	}
}
