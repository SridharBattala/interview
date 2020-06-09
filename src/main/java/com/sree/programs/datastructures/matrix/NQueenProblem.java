package com.sree.programs.datastructures.matrix;

import java.util.*;

public class NQueenProblem {
	static List<int[][]> output = new LinkedList<>();
	static int[][] chessBoard = new int[4][4];
	static int rowLength = chessBoard.length;
	static int colLength = chessBoard[0].length;

	public static void main(String args[]) {

		solveNQueenProblem(0);
		for (int[][] board : output) {
			MatrixHelper.print(board);
			System.out.println();
		}
	}

	public static List<int[][]> solveNQueenProblem(int rowIndex) {
		if (rowIndex == rowLength) {
			int[][] output1 = new int[rowLength][colLength];
			for (int i = 0; i < rowLength; i++) {
				output1[i] = Arrays.copyOf(chessBoard[i], rowLength);
			}
			output.add(output1);
		} else {

			for (int colIndex = 0; colIndex < colLength; colIndex++) {
				if (isSafe(rowIndex, colIndex)) {
					chessBoard[rowIndex][colIndex] = 1;
					solveNQueenProblem(rowIndex + 1);
					chessBoard[rowIndex][colIndex] = 0;
				}
			}
		}
		return output;
	}

	private static boolean isSafe(int rowIndex, int colIndex) {
		return checkForRightDiagonal(rowIndex, colIndex) && checkForLeftDiagonal(rowIndex, colIndex)
				&& checkForTop(rowIndex, colIndex);
	}

	private static boolean checkForLeftDiagonal(int rowIndex, int colIndex) {
		if (rowIndex == -1 || colIndex == -1) {
			return true;
		} else if (chessBoard[rowIndex][colIndex] == 1) {
			return false;
		} else {
			return checkForLeftDiagonal(rowIndex - 1, colIndex - 1);
		}

	}

	private static boolean checkForTop(int rowIndex, int colIndex) {
		if (rowIndex == -1) {
			return true;
		} else if (chessBoard[rowIndex][colIndex] == 1) {
			return false;
		} else {
			return checkForTop(rowIndex - 1, colIndex);
		}

	}

	private static boolean checkForRightDiagonal(int rowIndex, int colIndex) {
		if (rowIndex == -1 || colIndex == colLength) {
			return true;
		} else if (chessBoard[rowIndex][colIndex] == 1) {
			return false;
		} else {
			return checkForRightDiagonal(rowIndex - 1, colIndex + 1);
		}

	}

}
