package com.sree.programs.datastructures.trie;

import java.util.*;

class WordDictionary {
	class TrieNode {
		Map<Character, TrieNode> childs = new HashMap<>();
		boolean isWordEnd = false;

		public TrieNode() {

		}
	}

	TrieNode trie = null;

	/** Initialize your data structure here. */
	public WordDictionary() {
		trie = new TrieNode();
	}

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("a");
		obj.addWord("a");
		System.out.println("search word .=" + obj.search("."));
		System.out.println("search word a=" + obj.search("a"));
	}

	public void addWord(String word) {
		TrieNode currentNode = this.trie;
		for (int i = 0; i < word.length(); i++) {
			Map<Character, TrieNode> currentChilds = currentNode.childs;
			if (!currentChilds.containsKey(word.charAt(i))) {
				TrieNode node = new TrieNode();
				currentChilds.put(word.charAt(i), node);
			}
			if (i == word.length() - 1) {
				currentChilds.get(word.charAt(i)).isWordEnd = true;
			}
			currentNode = currentChilds.get(word.charAt(i));
		}
	}

	public boolean search(String word) {
		System.out.println("search started for word= " + word);
		return helper(word, 0, this.trie);
	}

	public boolean helper(String word, int currentIndex, TrieNode currentNode) {
		if (currentIndex > word.length() - 1) {
			return false;
		} else {
			char currentChar = word.charAt(currentIndex);
			System.out.println("search started for currentChar= " + currentChar);
			Map<Character, TrieNode> currentChilds = currentNode.childs;

			if (!currentChilds.containsKey(currentChar)) {
				if (currentChar == '.') {
					Set<Character> keySet = currentChilds.keySet();
					if (currentIndex == word.length() - 1 && !keySet.isEmpty()) {
						System.out.println("case1");
						return true;
					} else {
						for (Character key : keySet) {
							if (helper(word, currentIndex + 1, currentChilds.get(key))) {
								System.out.println("case2");
								return true;
							}
						}
					}

				}
			} else {
				if (currentIndex == word.length() - 1 && currentChilds.get(currentChar).isWordEnd) {
					System.out.println("case3");
					return true;
				} else {
					System.out.println("case4");
					return helper(word, currentIndex + 1, currentChilds.get(currentChar));
				}

			}

		}

		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */
