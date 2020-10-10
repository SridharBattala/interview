package com.sree.programs.datastructures.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JavaArray {
	public static void main(String[] args) {
		/**
		 * array methods
		 */
		int[] array1 = new int[5];
		int[] array2 = new int[] { 1, 2, 3, 4, 5 };
		int[] array3 = { 1, 2, 3, 4, 5 };
		int length = array3.length;
		int[] subArray = Arrays.copyOfRange(array3, 1, 3);
		System.out.println("subArray=" + Arrays.toString(subArray));

		/**
		 * int array sort
		 */
		int[] arr = { 4, 10, 2, 15, 9 };
		Arrays.sort(arr);// ascending
		System.out.println("int array Sort=" + Arrays.toString(arr));
		/**
		 * int two dimentioanl array sort
		 */
		int[][] matrix = { { 2, 5 }, { 1, 4 } };
		Arrays.sort(matrix, (a, b) -> a[0] - b[0]);// ascending
		for (int[] matrixArr : matrix) {
			System.out.print("  matrix sort=" + Arrays.toString(matrixArr));
		}
		System.out.println();

		/**
		 * string array sort
		 */
		String[] strArr = { "4", "10", "2", "15", "9" };
		Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));// descending
		System.out.println("String array Sort=" + Arrays.toString(strArr));

		/**
		 * array to list
		 */
		Arrays.asList(array3);

	}
}
