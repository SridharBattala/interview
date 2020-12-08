package com.sree.programs.algorithms.dynamicprogramming;

import java.util.*;

public class SubsequencePatterenMatching {
	static int count = 0;

	public static void main(String[] args) {
		String input = "tomorrow";
		String patteren = "tor";
		getPatterenMatchingCount(input, patteren);
		System.out.println("count=" + count);
	}

	private static void getPatterenMatchingCount(String input, String patteren) {

		helper(input, patteren, 0, 0);

	}

	private static void helper(String input, String patteren, int inputIndex, int patterenIndex) {
		if (inputIndex == input.length() && patterenIndex == patteren.length()) {

			count++;
			return;
		} else {
			if (patterenIndex < patteren.length() && inputIndex < input.length()
					&& input.charAt(inputIndex) == patteren.charAt(patterenIndex)) {

				helper(input, patteren, inputIndex + 1, patterenIndex + 1);

			}

			if (inputIndex < input.length()) {
				helper(input, patteren, inputIndex + 1, patterenIndex);
			}
		}
	}
}
