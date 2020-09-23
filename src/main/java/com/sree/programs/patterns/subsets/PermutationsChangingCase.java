package com.sree.programs.patterns.subsets;

import java.util.*;

public class PermutationsChangingCase {
	public static void main(String[] args) {

		List<String> result = findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

		// result =
		// LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
		// System.out.println(" String permutations are: " + result);
	}

	private static List<String> findLetterCaseStringPermutations(String input) {
		List<String> output = new LinkedList<>();
		Queue<String> queue = new LinkedList<>();
		queue.add("");
		int index = 0;
		while (index < input.length()) {
			System.out.println("queue=" + queue.toString());
			Character lowerCase = input.charAt(index);
			Character upperCase = Character.toUpperCase(lowerCase);
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				String currentString = queue.poll();
				if (Character.isDigit(lowerCase)) {
					queue.offer(currentString + lowerCase);
				} else {
					queue.offer(currentString + lowerCase);
					queue.offer(currentString + upperCase);
				}

			}

			index++;

		}
		output.addAll(queue);
		return output;
	}

}
