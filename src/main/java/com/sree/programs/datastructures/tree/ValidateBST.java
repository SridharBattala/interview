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
		TreeNode1.left = TreeNode2;
		TreeNode1.right = TreeNode3;
		TreeNode2.left = TreeNode4;
		TreeNode2.right = TreeNode5;
		TreeNode4.left = TreeNode6;
		TreeNode4.right = TreeNode7;

		System.out.println(" isValidBST=" + isValidBST(TreeNode1));
	}

	public static boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public static boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;

		int val = node.data;
		if (lower != null && val <= lower)
			return false;
		if (upper != null && val >= upper)
			return false;

		if (!helper(node.right, val, upper))
			return false;
		if (!helper(node.left, lower, val))
			return false;
		return true;
	}

}
