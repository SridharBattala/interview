package com.sree.programs.datastructures.matrix;

import java.util.*;

//https://www.educative.io/courses/coderust-hacking-the-coding-interview/k56r6
public class MakeZeroes {

	static int[][] matrix = { { 5, 4, 3, 9 }, { 2, 0, 7, 9 }, { 1, 3, 4, 0 }, { 9, 8, 3, 4 } };

	public static void main(String[] args) {

		int[][] output = makeZeros();
		MatrixHelper.print(output);
	}

	private static int[][] makeZeros() {
		Set<Integer> zeroCols = new HashSet<>();
		Set<Integer> zeroRows = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}
		// make rows zeros
		for (Integer row : zeroRows) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[row][i] = 0;
			}
		}
		// make cols zeros
		for (Integer col : zeroCols) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][col] = 0;
			}
		}
		return matrix;
	}

}