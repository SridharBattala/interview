package com.sree.programs.datastructures.matrix;

import java.io.*;

class SpiralCopy {
	public static void spiralCopy(int[][] matrix) {

		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		// Defining the boundaries of the matrix.
		int left = 0;
		int right = colLength - 1;
		int top = 0;
		int bottom = rowLength - 1;

		while ((bottom >= top) && (right >= left)) {
			for (int j = left; j <= right; j++) {
				System.out.print(matrix[top][j] + " ");
			}

			// Since we have traversed the whole first
			// row, move down to the next row.
			top++;

			for (int i = top; i <= bottom; i++) {
				System.out.print(matrix[i][right] + " ");
			}

			// Since we have traversed the whole last
			// column, move down to the previous column.
			right--;

			for (int j = right; j >= left; j--) {
				System.out.print(matrix[bottom][j] + " ");
			}

			// Since we have traversed the whole last
			// row, move down to the previous row.
			bottom--;

			for (int i = bottom; i >= top; i--) {
				System.out.print(matrix[i][left] + " ");
			}

			// Since we have traversed the whole first
			// column, move down to the next column.
			left++;
		}
	}

	public static void main(String[] args) {
		// Driver code
		// Change the following array to test
		// on some other input
		int a[][] = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		spiralCopy(a);
	}
}