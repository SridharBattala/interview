package com.sree.programs.datastructures.heap;

/*
 * https://algorithms.tutorialhorizon.com/heap-sort-java-implementation/
 * https://www.educative.io/courses/data-structures-coding-interviews-java/JPX181R2Vzv
 */
import java.util.*;

public class HeapSort {

	public static void main(String args[]) {
		int[] arr = { 9, 10, 5, 3, 1, 2, 6 };
		System.out.println("Original array is: " + Arrays.toString(arr));
		HeapSort.sort(arr);
		System.out.println("Sorted array is (Heap Sort): " + Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		// build heap
		for (int index = (arr.length - 1) / 2; index >= 0; index--) {
			heapify(arr, arr.length, index);
		}
		System.out.println("Heap array is (Heap Sort): " + Arrays.toString(arr));
		for (int index = arr.length - 1; index >= 0; index--) {
			// swap first with last element
			swap(arr, 0, index);
			heapify(arr, index, 0);
		}

	}

	private static void heapify(int[] arr, int arrSize, int parentIndex) {
		int largest = parentIndex;

		while (largest < arrSize / 2) {// check parent nodes only
			int leftIndex = (2 * parentIndex) + 1;
			int rightIndex = (2 * parentIndex) + 2;
			if (leftIndex < arrSize && arr[leftIndex] > arr[largest]) {
				largest = leftIndex;
			}
			if (rightIndex < arrSize && arr[rightIndex] > arr[largest]) {
				largest = rightIndex;
			}
			if (largest != parentIndex) {
				swap(arr, largest, parentIndex);
				parentIndex = largest;
			} else {
				break;
			}
		}

	}

	private static void swap(int[] arr, int parentIndex, int elementIndex) {
		int x = arr[parentIndex];
		arr[parentIndex] = arr[elementIndex];
		arr[elementIndex] = x;
	}
}
