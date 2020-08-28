package com.sree.programs.important.leetcodetop75;

public class MatrixUniquePathsCount {

	public static void main(String args[]) {

		System.out.println("count=" + uniquePathsCount(2, 3));
		System.out.println("count=" + uniquePathsCount(3, 7));
	}

	// driver method
	private static int uniquePathsCount(int rows, int cols) {
		return uniquePathsCountRecursive(rows, cols, 0, 0);

	}

	private static int uniquePathsCountRecursive(int rows, int cols, int rowIndex, int colIndex) {
		if (rowIndex == rows - 1 && colIndex == cols - 1) {
			return 1;
		}
		// right
		int count1 = 0;
		if (colIndex + 1 <= cols - 1) {
			count1 = uniquePathsCountRecursive(rows, cols, rowIndex, colIndex + 1);
		}
		// down
		int count2 = 0;
		if (rowIndex + 1 <= rows - 1) {
			count2 = uniquePathsCountRecursive(rows, cols, rowIndex + 1, colIndex);
		}
		return count1 + count2;
	}

}
