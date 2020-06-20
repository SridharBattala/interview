package com.sree.programs.patterns.slidingwindow;

import java.util.*;

class WordConcatenation {
	public static List<Integer> findWordConcatenation(String input, String[] words) {
		Map<String, Integer> wordFreqMap = new HashMap<>();
		List<Integer> output = new LinkedList<>();
		for (int index = 0; index < words.length; index++) {
			wordFreqMap.put(words[index], wordFreqMap.getOrDefault(words[index], 0) + 1);
		}
		// loop input
		int wordsCount = words.length;
		int wordLength = words[0].length();
		for (int index = 0; index < input.length() - (wordsCount * wordLength); index++) {
			Map<String, Integer> wordsVisited = new HashMap<>();
			for (int j = 0; j < wordsCount; j++) {
				int startIndex = index + j * wordLength;
				String word = input.substring(startIndex, startIndex + wordLength);
				// check wordFreqMap contains word or not
				if (wordFreqMap.containsKey(word)) {
					wordsVisited.put(word, wordsVisited.getOrDefault(word, 0) + 1);
					if (wordsVisited.get(word) > wordFreqMap.get(word)) {
						break;
					} else {
						if (j + 1 == wordsCount) {
							output.add(index);
						}
					}
				} else {
					break;
				}

			}
		}
		return output;
	}

	public static void main(String[] args) {
		List<Integer> result = null;
		// List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat",
		// new String[] { "cat", "fox" });
		// System.out.println(result);
		result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
		System.out.println(result);
	}
}
