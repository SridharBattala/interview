package com.sree.programs.algorithms.backtracking;

import java.util.*;
import javafx.util.*;

public class WordSearchPractise2 {
	static int rows = 0;
	static int cols = 0;
	static LinkedList<Pair<Integer, Integer>> outputList = new LinkedList<>();

	public static void main(String[] args) {
		char[][] matrix = { { 'A', 'B', 'C', 'E' }, { 'B', 'F', 'C', 'S' }, { 'C', 'D', 'E', 'E' } };
		rows = matrix.length;
		cols = matrix[0].length;

		String word = "ABFBA";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == word.charAt(0)) {
					LinkedList<Pair<Integer, Integer>> currentPath = new LinkedList<>();
					System.out.println("First character =" + matrix[i][j]);
					searchWord(matrix, word, i, j, 0, outputList);
					if (!outputList.isEmpty()) {

						System.out.println("output=" + outputList);
						return;

					}
				}
			}
		}
		System.out.println("word not exist");

	}

	private static void searchWord(char[][] matrix, String word, int row, int col, int wordIndex,
			LinkedList<Pair<Integer, Integer>> currentPath) {
		currentPath.add(new Pair<>(row, col));
		if (wordIndex == word.length() - 1) {
			outputList = new LinkedList<>(currentPath);
			return;
		} else {

			if (isSafe(row + 1, col) && matrix[row + 1][col] == word.charAt(wordIndex + 1)) {
				System.out.println("character down=" + matrix[row + 1][col]);
				searchWord(matrix, word, row + 1, col, wordIndex + 1, outputList);
			}
			if (isSafe(row - 1, col) && matrix[row - 1][col] == word.charAt(wordIndex + 1)) {
				System.out.println("character up=" + matrix[row - 1][col]);
				searchWord(matrix, word, row - 1, col, wordIndex + 1, outputList);
			}
			if (isSafe(row, col + 1) && matrix[row][col + 1] == word.charAt(wordIndex + 1)) {
				System.out.println("character right=" + matrix[row][col + 1]);
				searchWord(matrix, word, row, col + 1, wordIndex + 1, outputList);
			}
			if (isSafe(row, col - 1) && matrix[row][col - 1] == word.charAt(wordIndex + 1)) {
				System.out.println("character left=" + matrix[row][col - 1]);

				searchWord(matrix, word, row, col - 1, wordIndex + 1, outputList);
			}
			System.out.println("character =" + word.charAt(wordIndex + 1) + ", currentPath=" + outputList);

			currentPath.removeLast();

		}

	}

	private static boolean isSafe(int row, int col) {
		return row >= 0 && row <= rows - 1 && col >= 0 && col <= cols - 1;

	}
}
