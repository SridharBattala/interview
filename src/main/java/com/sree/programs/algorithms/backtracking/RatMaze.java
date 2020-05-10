package com.sree.programs.algorithms.backtracking;

import com.sree.programs.datastructures.matrix.MatrixHelper;

public class RatMaze {
	static int[][] input = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0 },
			{ 1, 1, 0, 1, 1 } };

	static int rows = input.length;
	static int cols = input[0].length;
	static int[][] output = new int[rows][cols];

	public static void main(String[] args) {
		if (solveMaze(0, 0)) {
			MatrixHelper.print(output);
		} else {
			System.out.println("not found path");
		}
	}

	private static boolean solveMaze(int rowIndex, int colIndex) {
		// base case 1
		if (rowIndex < 0 || colIndex < 0 || rowIndex >= rows || colIndex >= cols || input[rowIndex][colIndex] != 1
				|| output[rowIndex][colIndex] == 1) {
			return false;
		}
		// base case 2
		else if (rowIndex == rows - 1 && colIndex == cols - 1) {
			output[rowIndex][colIndex] = 1;

			return true;
		}
		// recursive case
		else {
			output[rowIndex][colIndex] = 1;
			// top
			if (solveMaze(rowIndex - 1, colIndex)) {
				return true;
			}
			// bottom
			if (solveMaze(rowIndex + 1, colIndex)) {
				return true;
			}
			// left
			if (solveMaze(rowIndex, colIndex - 1)) {
				return true;
			}
			// right
			if (solveMaze(rowIndex, colIndex + 1)) {
				return true;
			}
			// back track
			output[rowIndex][colIndex] = 0;
			return false;
		}
	}

}
