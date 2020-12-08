package com.sree.programs.datastructures.tree;

import java.util.*;

public class NthHighestNumber {
	public static void main(String args[]) {
		String[] preOrder = { "100", "50", "25", null, null, "75", null, null, "200", "125", null, null, "350", null,
				null };
		TreeNode root = BinaryTree.createBT(preOrder);
		BinaryTree.printBT(root);
		getNthHighestNumber(root, 4);
	}

	private static void getNthHighestNumber(TreeNode root, int k) {
		PriorityQueue<TreeNode> minHeap = new PriorityQueue<TreeNode>((a, b) -> a.data - b.data);
		inorderTraversal(root, minHeap, k);
		System.out.println("nth highest=" + minHeap.peek().data);
	}

	private static void inorderTraversal(TreeNode root, PriorityQueue<TreeNode> minHeap, int k) {
		if (root == null) {
			return;
		} else {
			if (minHeap.size() < k) {
				minHeap.add(root);
			} else if (root.data > minHeap.peek().data) {
				minHeap.poll();
				minHeap.add(root);
			}
			inorderTraversal(root.left, minHeap, k);
			inorderTraversal(root.right, minHeap, k);
		}

	}
}
