package com.sree.programs.patterns.kwaymerge;

import java.util.*;

class Node {
	int row;
	int col;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class KthSmallestInSortedMatrix {

	public static int findKthSmallest(int[][] matrix, int k) {
		// create min heap
		PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> matrix[a.row][a.col] - matrix[b.row][b.col]);
		// add first first column elements
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < colLen; i++) {
			minHeap.add(new Node(i, 0));
		}
		// loop heap
		int currentCount = 0;
		while (!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			currentCount++;
			if (currentCount == k) {
				return matrix[node.row][node.col];
			} else if (node.col + 1 < colLen) {
				minHeap.add(new Node(node.row, node.col + 1));
			}

		}
		return 0;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
		int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}
