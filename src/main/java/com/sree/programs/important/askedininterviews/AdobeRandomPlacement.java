package com.sree.programs.important.askedininterviews;

import java.util.Arrays;
import java.util.Random;

public class AdobeRandomPlacement {
	public static void main(String args[]) {
		int[][] arr = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		placeMines(arr, 10);
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}

	}
	// {{0,1,0,1},{0,1,0,1},{0,1,0,1},{0,1,0,1}}

	// k mines
	// k=10
	private static void placeMines(int[][] grid, int minesCount) {

		int m = grid.length, n = grid[0].length;
		int currentMinesCount = 0;
		Random random = new Random();
		while (currentMinesCount != minesCount) {
			int index = random.nextInt(m * n);
			System.out.println("index=" + index);
			int i = index / m, j = index % n;
			if (grid[i][j] == 1) {
				grid[i][j] = 0;
				currentMinesCount++;
			}

		}
	}
}
