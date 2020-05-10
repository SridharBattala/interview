package com.sree.programs.algorithms.backtracking;

import com.sree.programs.datastructures.matrix.MatrixHelper;

public class SearchWordInMatrix {
	static char[][] input = { { 't', 'z', 'x', 'c', 'd' }, { 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
			{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };
	static int rows = input.length;
	static int cols = input[0].length;
	static String word = "horizon";
	public static int[][] output = new int[rows][cols];

	public static void main(String[] args) {

		if (searchWord()) {
			MatrixHelper.print(output);
		} else {
			System.out.println("NO PATH FOUND");
		}

	}

	public static boolean searchWord() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (search(i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean search(int row, int col, int index) {

		// check if current cell not already used or character in it is not not

		if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1 || output[row][col] != 0
				|| (index < word.length() && word.charAt(index) != input[row][col])) {
			return false;
		}

		if (index == word.length()) {
			return true;
		}

		// mark the current cell as 1

		output[row][col] = index + 1;

		if (search(row + 1, col, index + 1)) { // go down
			return true;
		}
		if (search(row - 1, col, index + 1)) { // go up
			return true;
		}
		if (search(row, col + 1, index + 1)) { // go right
			return true;
		}
		if (search(row, col - 1, index + 1)) { // go left
			return true;
		}
		if (search(row - 1, col + 1, index + 1)) { // go diagonally up right
			return true;
		}
		if (search(row - 1, col - 1, index + 1)) { // go diagonally up left
			return true;
		}
		if (search(row + 1, col - 1, index + 1)) { // go diagonally down left
			return true;
		}
		if (search(row + 1, col + 1, index + 1)) { // go diagonally down right
			return true;
		}

		// if none of the option works out, BACKTRACK and return false
		output[row][col] = 0;
		index = index - 1;
		return false;
	}

	public void print() {
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				System.out.print(" " + output[i][j]);
			}
			System.out.println();
		}
	}

}
