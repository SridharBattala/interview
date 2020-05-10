package com.sree.programs.datastructures.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/boggle-set-2-using-trie/ educative
 * 
 * @param args
 */
public class BoggleUsingTrie {

	static char[][] input = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
	static Set<String> inputWords = new HashSet<>();
	static Set<String> outputWords = new HashSet<>();
	static int rows = input.length;
	static int cols = input[0].length;
	static int[][] visited = new int[rows][cols];

	public static void main(String[] args) {
		inputWords.add("GEEKS");
		inputWords.add("FOR");
		inputWords.add("QUIZ");
		inputWords.add("GEE");

		// insert into trie
		TrieNode root = new TrieNode();
		Trie trie = new Trie();
		for (String word : inputWords) {
			trie.insert(root, word);
		}

		searchWord(root);
		// after traversing all the cells print output words
		System.out.println(outputWords);
	}

	public static void searchWord(TrieNode root) {
		int index = 0;
		String str = "";
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				index = input[row][col] - 'A';
				if (root.children[index] != null) {
					str = str + input[row][col];
					search(row, col, str, root.children[index]);
					str = "";
				}

			}
		}

	}

	public static void search(int row, int col, String word, TrieNode currentNode) {
		// base case
		if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1 || visited[row][col] != 0
				|| input[row][col] != word.charAt(word.length() - 1)) {
			return;
		}
		// recursive case
		else {
			// check for current node is end word
			if (currentNode.isEndWord) {
				outputWords.add(word);
			}

			// mark the current cell as 1
			visited[row][col] = 1;

			// loop all children of current node
			for (int i = 0; i < 26; i++) {
				if (currentNode.children[i] != null) {
					// add current letter to word
					char ch = (char) (i + 'A');
					word = word + ch;
					// check next word in trie matches with any neighbor of current cell
					search(row + 1, col, word, currentNode.children[i]); // go down

					search(row - 1, col, word, currentNode.children[i]); // go up

					search(row, col + 1, word, currentNode.children[i]); // go right

					search(row, col - 1, word, currentNode.children[i]); // go left

					search(row - 1, col + 1, word, currentNode.children[i]); // go diagonally up right

					search(row - 1, col - 1, word, currentNode.children[i]); // go diagonally up left

					search(row + 1, col - 1, word, currentNode.children[i]); // go diagonally down left

					search(row + 1, col + 1, word, currentNode.children[i]); // go diagonally down right
					// back track
					word = word.substring(0, word.length() - 1);
				}
			}
			// if none of the option works out, BACKTRACK and return false
			visited[row][col] = 0;

		}
	}

}
