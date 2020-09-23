package com.sree.programs.algorithms.backtracking;

import java.util.Arrays;

import javafx.util.*;

public class SudokuPractise {
	public static int[][] grid;
	public static int rows;
	public static int cols;

	public static void main(String[] args) {
		grid = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		rows = grid.length;
		cols = grid[0].length;

		Pair<Integer, Integer> pair = getNextBlankCell();
		solveSudoku(pair.getKey(), pair.getValue());

	}

	private static void solveSudoku(int row, int col) {
		if (row == rows && col == cols) {
			for (int k = 0; k < rows; k++) {
				System.out.println(Arrays.toString(grid[k]));
			}
			System.out.println();
			return;
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isSafeToPlace(row, col, i)) {
					grid[row][col] = i;
					Pair<Integer, Integer> pair = getNextBlankCell();
					solveSudoku(pair.getKey(), pair.getValue());
					grid[row][col] = 0;
				}

			}
		}

	}

	private static boolean isSafeToPlace(int row, int col, int value) {

		// row check
		for (int i = 0; i < cols; i++) {
			if (grid[row][i] == value) {
				return false;
			}
		}
		// col check
		for (int i = 0; i < rows; i++) {
			if (grid[i][col] == value) {
				return false;
			}
		}
		// block check
		row = row - row % 3;
		col = col - col % 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + row][j + col] == value) {
					return false;
				}
			}
		}
		return true;
	}

	private static Pair<Integer, Integer> getNextBlankCell() {

		for (int row = 0; row <= rows - 1; row++) {
			for (int col = 0; col <= cols - 1; col++) {
				if (grid[row][col] == 0) {
					return new Pair<>(row, col);
				}
			}
		}
		return new Pair<>(rows, rows);
	}

}
