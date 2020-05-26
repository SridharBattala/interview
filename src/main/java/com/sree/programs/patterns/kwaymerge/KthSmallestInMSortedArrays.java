package com.sree.programs.patterns.kwaymerge;

import java.util.*;

class KthSmallestInMSortedArrays {
	public static class Node {
		int elementIndex;
		int arrIndex;

		public Node(int arrIndex, int elementIndex) {
			super();
			this.elementIndex = elementIndex;
			this.arrIndex = arrIndex;
		}

	}

	public static int findKthSmallest(List<Integer[]> lists, int k) {
		// base case
		if (lists.isEmpty()) {
			throw new IllegalArgumentException();
		}
		// create min heap
		PriorityQueue<Node> minHeap = new PriorityQueue<>(
				(a, b) -> lists.get(a.arrIndex)[a.elementIndex] - lists.get(b.arrIndex)[b.elementIndex]);
		// add first elements of all arrays
		for (int arrayIndex = 0; arrayIndex < lists.size(); arrayIndex++) {
			minHeap.add(new Node(arrayIndex, 0));
		}
		int counter = 0, output = 0;
		while (!minHeap.isEmpty()) {
			Node currentNode = minHeap.poll();
			counter++;
			if (counter == k) {
				output = lists.get(currentNode.arrIndex)[currentNode.elementIndex];
			} else {
				if (lists.get(currentNode.arrIndex).length - 1 > currentNode.elementIndex) {
					Node nextNode = new Node(currentNode.arrIndex, currentNode.elementIndex + 1);
					minHeap.add(nextNode);
				}

			}
		}
		return output;
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}
