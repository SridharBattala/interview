package com.sree.programs.datastructures.matrix;

import javafx.util.*;

public class SearchMatrix {
	static class Cell {
		int row;
		int col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 2, 4, 9, 13, 15 }, { 3, 5, 11, 18, 22 }, { 6, 8, 16, 21, 28 },
				{ 9, 11, 20, 25, 31 }, };

		Cell cell = searchInMatrix(matrix, 8);
		System.out.println("row=" + cell.row + " ,col=" + cell.col);
	}

	public static Cell searchInMatrix(int input[][], int target) {
		int rowLen = input.length;
		int colLen = input[0].length;
		// lets start from top right means 0,colLen-1
		int rowIndex = 0, colIndex = colLen - 1;
		while (rowIndex < rowLen && colIndex >= 0) {
			if (input[rowIndex][colIndex] == target) {
				return new Cell(rowIndex, colIndex);
			}
			if (input[rowIndex][colIndex] > target) {
				colIndex--;
			} else {
				rowIndex++;
			}
		}
		return new Cell(-1, -1);
	}
}
