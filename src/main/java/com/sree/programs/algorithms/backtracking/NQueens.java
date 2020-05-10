package com.sree.programs.algorithms.backtracking;

import com.sree.programs.datastructures.matrix.MatrixHelper;

public class NQueens {
	static int[][] input = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	static int rows = input.length;
	static int cols = input[0].length;

	public static void main(String args[]) {

		printAllNQueenSolutions(0);

	}

	public static void printAllNQueenSolutions(int row) {
		if (row == rows) {
			MatrixHelper.print(input);
			System.out.println();
		} else {
			for (int col = 0; col < cols; col++) {
				if (canPlace(row, col)) {
					input[row][col] = 1;
					printAllNQueenSolutions(row + 1);
					input[row][col] = 0;
				}
			}
		}

	}

	private static boolean canPlace(int row, int col) {
		return checkForUpperColumn(row, col) && checkForUpperRightDaigonal(row, col)
				&& CheckForUpperLeftDaigonal(row, col);

	}

	private static boolean CheckForUpperLeftDaigonal(int row, int col) {
		if (row < 0 || col < 0) {
			return true;
		} else if (input[row][col] == 1) {
			return false;
		} else {
			return CheckForUpperLeftDaigonal(row - 1, col - 1);
		}
	}

	private static boolean checkForUpperRightDaigonal(int row, int col) {
		if (row < 0 || col < 0 || col>=cols) {
			return true;
		} else if (input[row][col] == 1) {
			return false;
		} else {
			return checkForUpperRightDaigonal(row - 1, col + 1);
		}
	}

	private static boolean checkForUpperColumn(int row, int col) {
		if (row < 0) {
			return true;
		} else if (input[row][col] == 1) {
			return false;
		} else {
			return checkForUpperColumn(row - 1, col);
		}
	}
}
