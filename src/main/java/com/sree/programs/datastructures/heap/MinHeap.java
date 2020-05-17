package com.sree.programs.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.educative.io/courses/data-structures-coding-interviews-java/NE0MrPKAnWN
 * 
 * @author sridharbattala
 *
 */
public class MinHeap {
	public static List<Integer> minHeap = new ArrayList<>();

	public static void main(String[] args) {
		insert(20);
		insert(8);
		insert(15);
		insert(5);
		insert(2);
		insert(1);
		print();
		// insert(0);
		removeRoot();
		print();
	}

	private static void print() {
		for (Integer ele : minHeap) {
			System.out.print(ele + "-->");
		}
		System.out.println();
	}

	public static void removeRoot() {
		if (minHeap.isEmpty()) {
			return;
		} else if (minHeap.size() <= 2) {
			minHeap.remove(0);
		} else {
			// remove root element
			minHeap.remove(0);
			// remove last element and place in root
			int lastElement = minHeap.remove(minHeap.size() - 1);
			minHeap.add(0, lastElement);
			// bubble down
			bubbleDown(0);

		}
	}

	private static void bubbleDown(int parentIndex) {
		while (minHeap.size() > parentIndex) {
			int smallest = parentIndex;
			int leftIndex = getLeftChildIndex(parentIndex);
			int rightIndex = getRightChildIndex(parentIndex);
			// check with left
			if (minHeap.size() > leftIndex && minHeap.get(leftIndex) < minHeap.get(smallest)) {
				smallest = leftIndex;
			}
			// check with right
			if (minHeap.size() > rightIndex && minHeap.get(rightIndex) < minHeap.get(smallest)) {
				smallest = rightIndex;
			}
			if (smallest != parentIndex) {
				swap(smallest, parentIndex);
				parentIndex = smallest;
			} else {
				break;
			}

		}
	}

	/*
	 * check educative insert and delete methods before this
	 */
	public static void insert(int element) {
		minHeap.add(element);
		// if size is more than 1, bubble up
		if (minHeap.size() > 1) {
			bubbleUp(getParentIndex(minHeap.indexOf(element)));
		}

	}

	private static void bubbleUp(int parentIndex) {

		while (parentIndex > -1) {
			int smallest = parentIndex;
			int leftIndex = getLeftChildIndex(parentIndex);
			int rightIndex = getRightChildIndex(parentIndex);
			// check with left
			if (minHeap.size() > leftIndex && minHeap.get(leftIndex) < minHeap.get(smallest)) {
				smallest = leftIndex;
			}
			// check with right
			if (minHeap.size() > rightIndex && minHeap.get(rightIndex) < minHeap.get(smallest)) {
				smallest = rightIndex;
			}
			if (smallest != parentIndex) {
				swap(smallest, parentIndex);
				parentIndex = getParentIndex(parentIndex);
			} else {
				break;
			}
		}
	}

	private static int getRightChildIndex(int index) {
		return (2 * index) + 2;
	}

	private static int getLeftChildIndex(int index) {
		return (2 * index) + 1;
	}

	private static void swap(int parentIndex, int elementIndex) {
		int temp = minHeap.get(parentIndex);
		minHeap.set(parentIndex, minHeap.get(elementIndex));
		minHeap.set(elementIndex, temp);
	}

	private static int getParentIndex(int index) {
		if (index == 0) {
			return -1;
		} else {
			return (int) Math.floor((index - 1) / 2);
		}

	}
}
