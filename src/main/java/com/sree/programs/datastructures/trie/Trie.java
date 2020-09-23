package com.sree.programs.datastructures.trie;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/trie-insert-and-search/ educative
 * 
 * @author sridharbattala
 *
 */
class Trie {

	public static void main(String args[]) {
		String[] input = { "ABC", "ABD", "ABCD" };
		TrieNode root = new TrieNode();
		for (int i = 0; i < input.length; i++) {
			insert(root, input[i]);
		}
		List<String> allWords = new LinkedList<>();
		getAllTheWords(root, "", allWords);
		System.out.println("print all words" + allWords.toString());
		System.out.println("search word=" + search(root, "ABDC"));
		System.out.println("prefix words=" + getWordsContainsPrefix(root, "ABC"));

	}

	public static void insert(TrieNode root, String word) {
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!root.containsChar(currentChar)) {
				root.put(currentChar, new TrieNode());
			}
			root = root.get(currentChar);
		}
		root.isEndWord = true;

	}

	private static void getAllTheWords(TrieNode root, String currentString, List<String> output) {

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				currentString = currentString + root.getCharByIndex(i);
				// check for end
				if (root.children[i].isEndWord) {
					output.add(currentString);
				}
				getAllTheWords(root.children[i], currentString, output);
				currentString = currentString.substring(0, currentString.length() - 1);
			}
		}
	}

	private static List<String> getWordsContainsPrefix(TrieNode root, String prefix) {
		List<String> words = new LinkedList<>();
		for (int i = 0; i < prefix.length(); i++) {
			char currentChar = prefix.charAt(i);
			if (!root.containsChar(currentChar)) {
				return words;
			}
			root = root.get(currentChar);
		}
		if (root.isEndWord) {
			words.add(prefix);
		}
		getAllTheWords(root, prefix, words);
		return words;
	}

	private static boolean search(TrieNode root, String word) {

		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!root.containsChar(currentChar)) {
				return false;
			}
			root = root.get(currentChar);
		}
		if (root.isEndWord) {
			return true;
		} else {
			return false;
		}
	}
}