package com.sree.programs.algorithms.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sree.programs.datastructures.matrix.MatrixHelper;

/**
 * https://www.youtube.com/watch?v=T0z1VFXegQk&list=PLjhq5EHRYAeL_jb3M4TqyMBSLXkTcyhge&index=3
 * educative
 * 
 * @author sridharbattala
 *
 */
public class Boggle {

	static char[][] input = { { 'c', 'a', 't' }, { 'q', 'e', 'r' }, { 't', 'o', 'n' } };
	static Set<String> inputWords = new HashSet<>();
	static Set<String> outputWords = new HashSet<>();
	static int rows = input.length;
	static int cols = input[0].length;
	static int[][] visited = new int[rows][cols];

	public static void main(String[] args) {
		inputWords.add("cat");
		inputWords.add("cater");
		inputWords.add("art");
		inputWords.add("toon");
		inputWords.add("moon");
		inputWords.add("not");
		inputWords.add("eat");
		inputWords.add("ton");
		searchWord();
	}

	public static void searchWord() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				search(i, j, "");
			}
		}
		// after traversing all the cells print output words
		System.out.println(outputWords);
	}

	public static void search(int row, int col, String word) {

		// base case
		if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1 || visited[row][col] != 0) {
			return;
		}
		// recursive case
		else {
			// check for each word formation whether it contains in input words or not
			if (inputWords.contains(word)) {
				outputWords.add(word);
			}

			// mark the current cell as 1
			visited[row][col] = 1;
			// add current letter to word
			word = word + input[row][col];

			search(row + 1, col, word); // go down

			search(row - 1, col, word); // go up

			search(row, col + 1, word); // go right

			search(row, col - 1, word); // go left

			search(row - 1, col + 1, word); // go diagonally up right

			search(row - 1, col - 1, word); // go diagonally up left

			search(row + 1, col - 1, word); // go diagonally down left

			search(row + 1, col + 1, word); // go diagonally down right

			// if none of the option works out, BACKTRACK and return false
			visited[row][col] = 0;
			word = word.substring(0, word.length() - 1);

		}
	}

}
