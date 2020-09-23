package com.sree.programs.datastructures.trie;

class TrieNode {
	TrieNode[] children;
	boolean isEndWord; // will be true if the node represents the end of word

	TrieNode() {
		this.isEndWord = false;
		this.children = new TrieNode[26]; // Total # of English Alphabets = 26
	}

	public void put(char ch, TrieNode node) {
		children[ch - 'A'] = node;
	}

	public TrieNode get(char ch) {
		return children[ch - 'A'];
	}

	public char getCharByIndex(int index) {
		return (char) (index + 'A');
	}

	public boolean containsChar(char ch) {
		if (children[ch - 'A'] != null) {
			return true;
		}
		return false;
	}
}
