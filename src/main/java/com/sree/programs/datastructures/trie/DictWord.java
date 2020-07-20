package com.sree.programs.datastructures.trie;

import java.util.*;

public class DictWord {
	static class TrieNode1 {
		TrieNode1 childrens[];
		boolean isEndWord;

		TrieNode1() {
			this.isEndWord = false;
			childrens = new TrieNode1[26];
		}
	}

	static class Trie1 {
		// 1)loop input string for every character
		// 2)check root children's contains current character, if contains assign root
		// =children
		// 3)if not contains, get the index for current character and create new node
		// and place in index and assign root=children
		public void insert(TrieNode1 root, String input) {
			for (int index = 0; index < input.length(); index++) {
				char ch = input.charAt(index);
				int charIndex = ch - 'a';
				if (root.childrens[charIndex] == null) {
					root.childrens[charIndex] = new TrieNode1();
				}
				root = root.childrens[charIndex];
			}
			root.isEndWord = true;
		}
	}

	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };

		System.out.println("Keys: " + Arrays.toString(keys));

		// Construct trie
		Trie1 t = new Trie1();
		TrieNode1 root = new TrieNode1();
		for (int i = 0; i < keys.length; i++)
			t.insert(root, keys[i]);

		System.out.println("totalWords=" + printAllWords(root).toString());
	}

	// 1)base case
	// if root is enddWord, then count++
	// 2)recursive case
	// a)loop 26 children of root and check any where nodes are present,
	// if present root=currentChildersn and call recursively
	private static List<String> printAllWords(TrieNode1 root) {
		List<String> output = new LinkedList<>();
		return printAllWordsRecursive(root, "", output);
	}

	// recursive method
	private static List<String> printAllWordsRecursive(TrieNode1 root, String currentString, List<String> output) {

		// no base case
		// recursive case

		TrieNode1 children[] = root.childrens;
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				char currentChar = (char) (i + 'a');
				currentString = currentString + Character.toString(currentChar);
				if (children[i].isEndWord) {
					output.add(currentString);
				}
				printAllWordsRecursive(children[i], currentString, output);
				// remove last character
				// back tracking
				currentString = currentString.substring(0, currentString.length() - 1);
			}

		}
		return output;
	}

}
