package com.sree.programs.patterns.bfs;

import java.util.*;

public class ZigzagTraversal {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigzagTraversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);
	}

	private static List<List<Integer>> traverse(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<List<Integer>> output = new LinkedList<>();
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelValues = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queue.remove();

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
				if (leftToRight) {
					levelValues.add(currentNode.val);

				} else {
					levelValues.add(0, currentNode.val);

				}
			}
			// reverse the traversal direction
			leftToRight = !leftToRight;
			output.add(levelValues);
		}
		return output;
	}
}
