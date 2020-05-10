package com.sree.programs.algorithms.backtracking;

import com.sree.programs.datastructures.matrix.MatrixHelper;

/**
 * https://algorithms.tutorialhorizon.com/backtracking-knights-tour-problem/
 * https://www.youtube.com/watch?v=pwlxQeHchFQ
 * 
 * @author sridharbattala
 *
 */
public class KnightTour {

	static int[][] output = MatrixHelper.createMatrix(8, 8, -1);
	static int rows = output.length;
	static int cols = output.length;

	public static void main(String[] args) {
		if (findpath(0, 0, 0)) {
			MatrixHelper.print(output);
		} else {
			System.out.println("no path found");
		}
	}

	private static boolean findpath(int row, int col, int outputCellValue) {
		// base case 1
		if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1 || output[row][col] != -1) {
			return false;
		}
		// base case 2
		else if (outputCellValue == (rows * cols) - 1) {
			output[row][col] = outputCellValue;
			return true;
		}

		// recursive case
		else {
			output[row][col] = outputCellValue;
			// go down and right
			if (findpath(row + 2, col + 1, outputCellValue + 1)) {
				return true;
			}
			// go right and down
			if (findpath(row + 1, col + 2, outputCellValue + 1)) {
				return true;
			}
			// go right and up
			if (findpath(row - 1, col + 2, outputCellValue + 1)) {
				return true;
			}
			// go up and right
			if (findpath(row - 2, col + 1, outputCellValue + 1)) {
				return true;
			}

			// go up and left
			if (findpath(row - 2, col - 1, outputCellValue + 1)) {
				return true;
			}
			// go left and up
			if (findpath(row - 1, col - 2, outputCellValue + 1)) {
				return true;
			}
			// go left and down
			if (findpath(row + 1, col - 2, outputCellValue + 1)) {
				return true;
			}
			// go down and left
			if (findpath(row + 2, col - 1, outputCellValue + 1)) {
				return true;
			}

			output[row][col] = -1;
			outputCellValue = outputCellValue - 1;
			return false;
		}

	}
}
