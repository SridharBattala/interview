package com.sree.programs.patterns.dfs;

import java.util.*;

public class CountAllPathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
	}

	private static int countPaths(TreeNode root, int target) {
		List<Integer> currentPath = new LinkedList<>();
		return helper(root, target, currentPath, 0);
	}

	private static int helper(TreeNode root, int target, List<Integer> currentPath, int currentCount) {
		if (root == null) {
			return currentCount;
		} else {

			currentPath.add(root.val);
			// loop current path and check matches for sub path
			int sum = 0;

			// find the sums of all sub-paths in the current path list
			ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
			while (pathIterator.hasPrevious()) {
				sum += pathIterator.previous();
				// if the sum of any sub-path is equal to 'S' we increment our path count.
				if (sum == target) {
					currentCount = currentCount + 1;
				}
			}

			// add left
			currentCount = helper(root.left, target, currentPath, currentCount);
			// add right
			currentCount = helper(root.right, target, currentPath, currentCount);
			// back tracking
			currentPath.remove(currentPath.size() - 1);

			return currentCount;
		}

	}
}
