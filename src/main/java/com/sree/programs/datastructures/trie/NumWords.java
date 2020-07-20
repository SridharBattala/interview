package com.sree.programs.datastructures.trie;

import java.util.*;

public class NumWords {
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

		System.out.println("totalWords=" + totalWords(root));
	}

	// 1)base case
	// if root is enddWord, then count++
	// 2)recursive case
	// a)loop 26 children of root and check any where nodes are present,
	// if present root=currentChildersn and call recursively
	private static int totalWords(TrieNode1 root) {
		return totalWordsRecursive(root, 0);
	}

	// recursive method
	private static int totalWordsRecursive(TrieNode1 root, int count) {
		// base case
		if (root == null) {
			return count;
		}

		// recursive case
		else {
			TrieNode1 children[] = root.childrens;
			for (int i = 0; i < children.length; i++) {
				if (children[i] != null && children[i].isEndWord) {
					count++;
				}
				count = totalWordsRecursive(children[i], count);
			}
			return count;
		}
	}
}
