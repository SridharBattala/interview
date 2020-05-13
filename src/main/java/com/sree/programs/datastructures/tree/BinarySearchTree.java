package com.sree.programs.datastructures.tree;

import java.util.*;

/**
 * educative
 */
public class BinarySearchTree {
	public static void main(String args[]) {
		List<Integer> array = Arrays.asList(100, 50, 25, 200, 350, 125);

		TreeNode root = insert(array);
		displayLevelOrder(root);
	}

	public static TreeNode insert(List<Integer> array) {
		TreeNode root = null;
		for (Integer value : array) {
			root = insert(root, value);
		}
		return root;
	}

	// returns root
	public static TreeNode insert(TreeNode root, int data) {
		// base case
		if (root == null) {
			return new TreeNode(data);
		}
		// recursive case
		else {
			if (data > root.data) {
				TreeNode right = insert(root.right, data);
				if (right.data == data) {
					root.right = right;
				}
				return root;
			} else {
				TreeNode left = insert(root.left, data);
				if (left.data == data) {
					root.left = left;
				}
				return root;
			}
		}

	}

	public static void displayLevelOrder(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);
			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				// add the node to the current level
				currentLevel.add(currentNode.data);
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			System.out.println(currentLevel);

		}
		System.out.println();
	}
}
