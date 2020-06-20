package com.sree.programs.patterns.subsets;

import java.util.*;

public class LetterCaseStringPermutation {
	public static List<String> findLetterCaseStringPermutations(String str) {
		Queue<String> queue = new LinkedList<>();
		// add empty string first
		queue.add("");

		for (int index = 0; index < str.length(); index++) {
			char ch = str.charAt(index);
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				String currentString = queue.poll();
				if (Character.isLetter(ch)) {
					String lowerCase = currentString + Character.toLowerCase(ch);
					String upeerCase = currentString + Character.toUpperCase(ch);
					queue.add(lowerCase);
					queue.add(upeerCase);
				} else {
					queue.add(currentString + ch);
				}
			}
		}
		List<String> output = new LinkedList<>();
		output.addAll(queue);
		return output;
	}

	public static void main(String[] args) {
		List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

		result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}
}
