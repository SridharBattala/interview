package com.sree.programs.datastructures.tree;

public class BinaryTreePractise {
	public static void main(String args[]) {
		TreeNode TreeNode1 = new TreeNode(10);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);
		TreeNode TreeNode6 = new TreeNode(6);
		TreeNode TreeNode7 = new TreeNode(7);
		TreeNode1.left = TreeNode2;
		TreeNode1.right = TreeNode3;
		TreeNode2.left = TreeNode4;
		TreeNode2.right = TreeNode5;
		TreeNode4.left = TreeNode6;
		TreeNode4.right = TreeNode7;

		System.out.println(" Min element=" + getMinElement(TreeNode1));
	}

	public static int getMinElement(TreeNode root) {
		return helper(root, Integer.MAX_VALUE);
	}

	public static int helper(TreeNode root, int currentMin) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int rootValue = root.data;
		int leftValue = helper(root.left, Math.min(root.data, currentMin));
		int rightValue = helper(root.right, Math.min(root.data, currentMin));
		return Math.min(Math.min(rootValue, leftValue), rightValue);
	}
}
