package com.sree.programs.datastructures.matrix;

import java.io.*;

class SpiralCopy {
	public static void spiralCopy(int[][] matrix) {

		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		// Defining the boundaries of the matrix.
		int colStart = 0;
		int colEnd = colLength - 1;
		int rowStart = 0;
		int rowEnd = rowLength - 1;

		while ((rowEnd >= rowStart) && (colEnd >= colStart)) {
			for (int j = colStart; j <= colEnd; j++) {
				System.out.print(matrix[rowStart][j] + " ");
			}

			// Since we have traversed the whole first
			// row, move down to the next row.
			rowStart++;
			if (rowStart > rowEnd) {
				break;
			}

			for (int i = rowStart; i <= rowEnd; i++) {
				System.out.print(matrix[i][colEnd] + " ");
			}

			// Since we have traversed the whole last
			// column, move down to the previous column.
			colEnd--;
			if (colStart > colEnd) {
				break;
			}
			for (int j = colEnd; j >= colStart; j--) {
				System.out.print(matrix[rowEnd][j] + " ");
			}

			// Since we have traversed the whole last
			// row, move down to the previous row.
			rowEnd--;
			if (rowStart > rowEnd) {
				break;
			}

			for (int i = rowEnd; i >= rowStart; i--) {
				System.out.print(matrix[i][colStart] + " ");
			}

			// Since we have traversed the whole first
			// column, move down to the next column.
			colStart++;
			if (colStart > colEnd) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		// Driver code
		// Change the following array to test
		// on some other input
		int arr1[][] = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		int arr2[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		spiralCopy(arr2);
	}
}