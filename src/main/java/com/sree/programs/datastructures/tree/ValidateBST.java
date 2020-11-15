package com.sree.programs.datastructures.tree;

public class ValidateBST {
	public static void main(String args[]) {
		TreeNode TreeNode1 = new TreeNode(1);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);
		TreeNode TreeNode6 = new TreeNode(6);
		TreeNode TreeNode7 = new TreeNode(7);
		TreeNode2.left = TreeNode1;
		TreeNode2.right = TreeNode3;
		// TreeNode2.left = TreeNode4;
		// TreeNode4.left = TreeNode3;
		// TreeNode4.right = TreeNode6;

		System.out.println(" isValidBST=" + isValidBST(TreeNode2));
	}

	public static boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean helper(TreeNode node, int lower, int upper) {
		if (node == null) {
			return true;
		} else {
			boolean leftSubTree = false;
			boolean rightSubTree = false;
			if (node.data > lower && node.data < upper) {
				leftSubTree = helper(node.left, lower, node.data);
				rightSubTree = helper(node.right, node.data, upper);
				return leftSubTree && rightSubTree;
			} else {
				return false;
			}
		}

	}

}
