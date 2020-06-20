package com.sree.programs.patterns.dfs;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};

public class PathWithGivenSequence {

	public static boolean findPath(TreeNode root, int[] sequence) {
		return helper(root, sequence, 0);
	}

	public static boolean helper(TreeNode root, int[] sequence, int index) {
		// base case
		if (index == sequence.length - 1 && root.val == sequence[index] && root.left == null && root.right == null) {
			return true;
		} else if (index == sequence.length || root == null) {
			return false;
		} else {

			if (root.val == sequence[index]) {

				return helper(root.left, sequence, index + 1) || helper(root.right, sequence, index + 1);

			} else {
				return false;
			}

		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}
}
