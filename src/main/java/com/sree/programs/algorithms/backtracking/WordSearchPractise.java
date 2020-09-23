package com.sree.programs.algorithms.backtracking;

import java.util.*;
import javafx.util.*;

public class WordSearchPractise {
	static int rows = 0;
	static int cols = 0;

	public static void main(String[] args) {
		char[][] matrix = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'B', 'E', 'E' } };
		rows = matrix.length;
		cols = matrix[0].length;
		String word = "BCCFB";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == word.charAt(0)) {
					System.out.println("First character =" + matrix[i][j]);
					LinkedList<Pair<Integer, Integer>> visitedPath = new LinkedList<>();
					if (searchWord(matrix, word, i, j, 0, visitedPath)) {
						System.out.println("isisted path=====" + visitedPath);
						System.out.println("word exist");
						return;
					}
				}
			}
		}
		System.out.println("word not exist");

	}

	private static boolean searchWord(char[][] matrix, String word, int row, int col, int wordIndex,
			LinkedList<Pair<Integer, Integer>> visitedPath) {
		boolean result = false;
		visitedPath.add(new Pair<>(row, col));
		if (wordIndex == word.length() - 1) {
			System.out.println(
					"character =" + word.charAt(wordIndex) + ", result=" + result + ", visitedPath=" + visitedPath);

			result = true;
		} else {
			boolean case1 = false;
			boolean case2 = false;
			boolean case3 = false;
			boolean case4 = false;

			if (isSafe(row + 1, col, visitedPath) && matrix[row + 1][col] == word.charAt(wordIndex + 1)) {
				System.out.println("character down=" + matrix[row + 1][col]);
				case1 = searchWord(matrix, word, row + 1, col, wordIndex + 1, visitedPath);
			}
			if (isSafe(row - 1, col, visitedPath) && matrix[row - 1][col] == word.charAt(wordIndex + 1)) {
				System.out.println("character up=" + matrix[row - 1][col]);
				case2 = searchWord(matrix, word, row - 1, col, wordIndex + 1, visitedPath);
			}
			if (isSafe(row, col + 1, visitedPath) && matrix[row][col + 1] == word.charAt(wordIndex + 1)) {
				System.out.println("character right=" + matrix[row][col + 1]);
				case3 = searchWord(matrix, word, row, col + 1, wordIndex + 1, visitedPath);
			}
			if (isSafe(row, col - 1, visitedPath) && matrix[row][col - 1] == word.charAt(wordIndex + 1)) {
				System.out.println("character left=" + matrix[row][col - 1]);
				case4 = searchWord(matrix, word, row, col - 1, wordIndex + 1, visitedPath);
			}
			result = case1 || case2 || case3 || case4;
			System.out.println(
					"character =" + word.charAt(wordIndex + 1) + ", result=" + result + ", visitedPath=" + visitedPath);

		}
		visitedPath.removeLast();
		return result;
	}

	private static boolean isSafe(int row, int col, LinkedList<Pair<Integer, Integer>> visitedPath) {
		return row >= 0 && row <= rows - 1 && col >= 0 && col <= cols - 1
				&& !visitedPath.contains(new Pair<>(row, col));

	}
}
