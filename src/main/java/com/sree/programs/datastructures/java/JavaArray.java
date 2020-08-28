package com.sree.programs.datastructures.java;

import java.util.Arrays;
import java.util.Collections;

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
		System.out.println("subArray=" + subArray);

		/**
		 * array sort
		 */
		Integer[] arr = { 2, 1, 3, 5, 4 };
		Arrays.sort(arr);// ascending
		Arrays.sort(arr, Collections.reverseOrder());// descending

		/**
		 * array to list
		 */
		Arrays.asList(array3);

	}
}
