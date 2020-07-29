package com.sree.programs.datastructures.matrix;

import java.io.*;
import java.util.*;

public class ShortestPath {

	static class Cell {
		int row;
		int col;
		int distance;

		Cell(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}

	}
	// define queue and add source to queue
	// add current source visited set
	// get all the neighbors of current source and loop the nigbours and if grid
	// cell contains 1, then increment count and add to queue
	// once u reach destination , return count

	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
		Queue<Cell> queue = new LinkedList<>();
		Cell cell = new Cell(sr, sc, 0);
		queue.offer(cell);
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		visited[sr][sc] = true;
		while (!queue.isEmpty()) {
			Cell current = queue.poll();
			if (current.row == tr && current.col == tc) {
				return current.distance;
			}

			// top
			if (current.row + 1 < grid.length && !visited[current.row + 1][current.col]
					&& grid[current.row + 1][current.col] == 1) {
				queue.offer(new Cell(current.row + 1, current.col, current.distance + 1));
				visited[current.row + 1][current.col] = true;
				// to-do
			}
			// bottom
			if (current.row - 1 >= 0 && !visited[current.row - 1][current.col]
					&& grid[current.row - 1][current.col] == 1) {
				queue.offer(new Cell(current.row - 1, current.col, current.distance + 1));
				visited[current.row - 1][current.col] = true;
			}
			// right
			if (current.col + 1 < grid[0].length && !visited[current.row][current.col + 1]
					&& grid[current.row][current.col + 1] == 1) {
				queue.offer(new Cell(current.row, current.col + 1, current.distance + 1));
				visited[current.row][current.col + 1] = true;
			}
			// left
			if (current.col - 1 >= 0 && !visited[current.row][current.col - 1]
					&& grid[current.row][current.col - 1] == 1) {
				queue.offer(new Cell(current.row, current.col - 1, current.distance + 1));
				visited[current.row][current.col - 1] = true;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 } };

		int distance = shortestCellPath(grid, 0, 0, 2, 0);
		System.out.println("distance= " + distance);
	}
}
