package com.sree.programs.datastructures.matrix;

/**
 * https://algorithms.tutorialhorizon.com/number-of-islands/
 */

public class NoOfIslandsRecursion {
	public static void main(String[] args) {

		char[][] islandGrid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println("No of Islands: " + numIslands(islandGrid));

		islandGrid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		System.out.println("No of Islands: " + numIslands(islandGrid));
	}

	public static int numIslands(char[][] islandGrid) {

		int count = 0;
		for (int row = 0; row < islandGrid.length; row++) {
			for (int col = 0; col < islandGrid[0].length; col++) {
				if (islandGrid[row][col] == '1') {
					checkForIsland(islandGrid, row, col);
					count++;
				}

			}
		}
		return count;
	}

	private static void checkForIsland(char[][] input, int row, int col) {
		input[row][col] = 0;

		// left
		if (col - 1 >= 0 && input[row][col - 1] == '1') {
			checkForIsland(input, row, col - 1);
		}
		// right
		if (col + 1 <= input[row].length - 1 && input[row][col + 1] == '1') {
			checkForIsland(input, row, col + 1);
		}
		// top
		if (row + 1 <= input.length - 1 && input[row + 1][col] == '1') {
			checkForIsland(input, row + 1, col);
		}
		// bottom
		if (row - 1 >= 0 && input[row - 1][col] == '1') {
			checkForIsland(input, row - 1, col);
		}

	}

}