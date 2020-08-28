package com.sree.programs.important.leetcodetop75;

import java.util.*;

public class MatrixUniquePaths {
	static class Cell {
		int row, col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return this.row + "," + this.col;
		}
	}

	public static void main(String args[]) {
		List<LinkedList<Cell>> output = uniquePathsCount(2, 3);
		for (LinkedList<Cell> cellList : output) {
			System.out.println("count=" + cellList.toString());
		}

		// System.out.println("count=" + uniquePathsCount(3, 7));
	}

	// driver method
	private static List<LinkedList<Cell>> uniquePathsCount(int rows, int cols) {
		LinkedList<Cell> list = new LinkedList<>();
		List<LinkedList<Cell>> output = new LinkedList<>();
		uniquePathsCountRecursive(rows, cols, 0, 0, list, output);
		return output;
	}

	private static void uniquePathsCountRecursive(int rows, int cols, int rowIndex, int colIndex, LinkedList<Cell> list,
			List<LinkedList<Cell>> output) {
		list.add(new Cell(rowIndex, colIndex));
		if (rowIndex == rows - 1 && colIndex == cols - 1) {
			output.add(new LinkedList<>(list));
		}
		// right

		if (colIndex + 1 <= cols - 1) {

			uniquePathsCountRecursive(rows, cols, rowIndex, colIndex + 1, list, output);
		}
		// down

		if (rowIndex + 1 <= rows - 1) {
			uniquePathsCountRecursive(rows, cols, rowIndex + 1, colIndex, list, output);
		}
		list.removeLast();
	}

}
