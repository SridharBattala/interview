package com.sree.programs.important.askedininterviews;

//package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class AmobeeMergeSortedArrays {
	/*
	 * 10,8 -->{1,3,4,7,10,-1,-1,10} 7,8 --> {1,3,4,7,10,-1,8,10} 7,3
	 * -->{1,3,4,7,10,7,8,10} 4,3 -->{1,3,4,7,4,7,8,10} 3,3 --> {1,3,3,3,4,7,8,10}
	 * 1,2 -->{1,2,3,3,4,7,8,10} 1 -->{1,2,3,3,4,7,8,10}
	 */
	public static void mergeTwoArrays(int[] arr1, int[] arr2) {
		int arr1Index = arr1.length - arr2.length - 1;
		int arr2Index = arr2.length - 1;
		int currentIndex = arr1.length - 1;
		while (currentIndex >= 0) {
			if (arr1[arr1Index] > arr2[arr2Index]) {
				arr1[currentIndex] = arr1[arr1Index];
				arr1Index--;
			} else {
				arr1[currentIndex] = arr2[arr2Index];
				arr2Index--;
			}
			currentIndex--;
			System.out.println(Arrays.toString(arr1));
		}
	}

	public static void main(String[] args) {

		int[] arr1 = new int[] { 2, 3, 4, 7, 10, -1, -1, -1 };// array 1 has enough space to contain array2
		int[] arr2 = new int[] { 1, 3, 8 };

		mergeTwoArrays(arr1, arr2);
		// merge them in sorted order
		System.out.println(Arrays.toString(arr1)); // 1,2,3,3,4,7,8,10
	}
}
