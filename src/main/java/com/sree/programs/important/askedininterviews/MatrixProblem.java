package com.sree.programs.important.askedininterviews;

//Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

//Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

//image1 = [
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 0, 0, 0, 1],
//[1, 1, 1, 0, 0, 0, 1],
//[1, 1, 1, 1, 1, 1, 1],
//]

//Sample output variations (only one is necessary):

//findRectangle(image1) =>
//x: 3, y: 2, width: 3, height: 2
//2,3 3,5 -- row,column of the top-left and bottom-right corners

//Other test cases:

//image2 = [
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 0],
//]

//findRectangle(image2) =>
//x: 6, y: 4, width: 1, height: 1
//4,6 4,6

//image3 = [
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 0, 0],
//[1, 1, 1, 1, 1, 0, 0],
//]

//findRectangle(image3) =>
//x: 5, y: 3, width: 2, height: 2
//3,5 4,6

//image4 = [
//[0, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//[1, 1, 1, 1, 1, 1, 1],
//]

//findRectangle(image4) =>
//x: 0, y: 0, width: 1, height: 1
//0,0 0,0

//image5 = [
//[0],
//]

//findRectangle(image5) =>
//x: 0, y: 0, width: 1, height: 1
//0,0 0,0

//n: number of rows in the input image
//m: number of columns in the input image

import java.util.*;

public class MatrixProblem {

	public static void main(String[] argv) {
		int[][] image1 = { { 1, 1, 1, 1,1 }, 
									{ 1, 0, 0, 1,1 }, 
									{ 1, 1, 1, 1,1  },
									{ 1, 1, 1, 1,1 }, 
									 };

		List<Integer> output = print(image1);
		System.out.println(output);

	}

	public static List<Integer> print(int[][] input) {
		boolean reachedZero = false;
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 0) {
					reachedZero = true;
					output.add(i);
					output.add(j);
					System.out.println("top=" + i + ", left=" + j);
					output.add(helperDown(input, i, j));
					output.add(helperRight(input, i, j));
					break;
				}
			}
			if (reachedZero) {
				break;
			}

		}
		return output;
	}

	public static int helperDown(int[][] input, int row, int col) {
		//base case
		if (row > input.length || input[row][col] == 1) {			
			return row - 1;
		} 
		//recursive case
		 else {
			int rowIndex = helperDown(input, row + 1, col);// down
			return rowIndex;
		}

	}
	public static int helperRight(int[][] input, int row, int col) {
		//base case
		if (col > input[0].length || input[row][col] == 1) {			
			return col - 1;
		} 
		//recursive case
		else {
			int colIndex = helperRight(input, row, col + 1);// right
			
			return colIndex;
		}

	}
}
