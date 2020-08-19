package com.sree.programs.datastructures.matrix;

import java.util.*;

public class RotAllOranges {
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
		int[][] input1 = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int[][] input2 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("min Hours=" + rotAllOranges(input2));
	}

	// loop all the cells and add cells contains 2 to queue
	// loop queue and rot adjacent neighbor cells which contains 1 and add those
	// cells to queue
	// loop continues until queue is empty
	private static int rotAllOranges(int[][] input) {
		Queue<Cell> queue = new LinkedList<>();
		// loop all the cells and add cells contains 2 to queue
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[0].length; col++) {
				if (input[row][col] == 2) {
					queue.offer(new Cell(row, col));
				}
			}
		}
		// loop queue and rot adjacent neighbor cells which contains 1 and add those
		// cells to queue
		int minHours = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println(queue.toString());
			minHours++;
			for (int i = 0; i < size; i++) {
				Cell cell = queue.poll();
				// left
				if (cell.col - 1 >= 0 && input[cell.row][cell.col - 1] == 1) {
					input[cell.row][cell.col - 1] = 2;
					queue.offer(new Cell(cell.row, cell.col - 1));
				}
				// right
				if (cell.col + 1 <= input[0].length - 1 && input[cell.row][cell.col + 1] == 1) {
					input[cell.row][cell.col + 1] = 2;
					queue.offer(new Cell(cell.row, cell.col + 1));
				}
				// bottom
				if (cell.row - 1 >= 0 && input[cell.row - 1][cell.col] == 1) {
					input[cell.row - 1][cell.col] = 2;
					queue.offer(new Cell(cell.row - 1, cell.col));
				}
				// top
				if (cell.row + 1 <= input.length - 1 && input[cell.row + 1][cell.col] == 1) {
					input[cell.row + 1][cell.col] = 2;
					queue.offer(new Cell(cell.row + 1, cell.col));
				}
			}
		}
		return minHours;
	}
}
