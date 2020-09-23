package com.sree.programs.datastructures.trie;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/boggle-set-2-using-trie/ educative
 * 
 * @param args
 */
public class BoggleUsingTriePractise {
	static TrieNode root;

	static char[][] input = { { 'A', 'S', 'B' }, { 'C', 'R', 'E' }, { 'C', 'I', 'E' } };
	static Set<String> inputWords = new HashSet<>();
	static Set<String> outputWords = new HashSet<>();
	static int rows = input.length;
	static int cols = input[0].length;
	static int[][] visited = new int[rows][cols];
	// 1) build trie
	// 2) traverse trie, matcg first char with any of the char in the grid,
	// then start traversing trie matching next character
	// any where in the trie, if u reach end word, the add to output

	public static void main(String[] args) {
		inputWords.add("SREE");
		inputWords.add("SRI");
		inputWords.add("SRIDHAR");
		// 1) build trie
		root = new TrieNode();
		for (String word : inputWords) {
			insert(root, word);
		}
		List<String> words = new LinkedList<>();
		getAllTheWords(root, "", words);
		System.out.println("print trie words=" + words.toString());
		searchWords(root);

		System.out.println("outputword=" + outputWords.toString());

	}

	private static void searchWords(TrieNode root) {
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[0].length; col++) {

				if (root.children[input[row][col] - 'A'] != null) {

					searchWord(input, root.children[input[row][col] - 'A'], row, col, "");
				}
			}
		}

	}

	private static void searchWord(char[][] input, TrieNode root, int row, int col, String currentString) {

		currentString = currentString + input[row][col];
		visited[row][col] = 1;
		if (root.isEndWord) {
			outputWords.add(currentString);
		}
		for (int i = 0; i < 25; i++) {
			if (root.children[i] != null) {
				// left
				if (col > 0 && visited[row][col - 1] == 0 && (char) (i + 'A') == input[row][col - 1]) {
					searchWord(input, root.children[input[row][col - 1] - 'A'], row, col - 1, currentString);
				}

				// right
				if (col < input[0].length - 1 && visited[row][col + 1] == 0
						&& (char) (i + 'A') == input[row][col + 1]) {
					searchWord(input, root.children[input[row][col + 1] - 'A'], row, col + 1, currentString);
				}
				// up
				if (row > 0 && visited[row - 1][col] == 0 && (char) (i + 'A') == input[row - 1][col]) {
					searchWord(input, root.children[input[row - 1][col] - 'A'], row - 1, col, currentString);
				}
				// down
				if (row < input.length - 1 && visited[row + 1][col] == 0 && (char) (i + 'A') == input[row + 1][col]) {
					searchWord(input, root.children[input[row + 1][col] - 'A'], row + 1, col, currentString);
				}
			}
		}

		currentString = currentString.substring(0, currentString.length() - 1);
		visited[row][col] = 0;
	}

	private static void insert(TrieNode root, String word) {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'A';
			if (root.children[index] == null) {
				root.children[index] = new TrieNode();
			}
			root = root.children[index];
		}
		root.isEndWord = true;

	}

	private static void getAllTheWords(TrieNode root, String currentString, List<String> output) {

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				currentString = currentString + (char) (i + 'A');
				// check for end
				if (root.children[i].isEndWord) {
					output.add(currentString);
				}
				getAllTheWords(root.children[i], currentString, output);
				currentString = currentString.substring(0, currentString.length() - 1);
			}
		}
	}

}
