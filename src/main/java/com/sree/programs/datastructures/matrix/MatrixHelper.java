package com.sree.programs.datastructures.matrix;

import java.util.List;
import java.util.Queue;

public class MatrixHelper {
	public static void print(List<List<Integer>> matrix) {
		for (List<Integer> row : matrix) {
			for (Integer colValue : row) {
				System.out.print(colValue + " ");
			}
			System.out.println();
		}
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print(Queue<List<Integer>> matrix) {
		for (List<Integer> row : matrix) {
			for (Integer colValue : row) {
				System.out.print(colValue + " ");
			}
			System.out.println();
		}
	}

	public static int[][] createMatrix(int rowSize, int colSize, int defaultValue) {
		int[][] matrix = new int[rowSize][colSize];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = defaultValue;
			}
		}
		return matrix;
	}
}
