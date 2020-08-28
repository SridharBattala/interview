package com.sree.programs.datastructures.tree;

public class MaxDepth {
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

		System.out.println("max depth=" + maxDepth(TreeNode1));
	}

	public static int maxDepth(TreeNode A) {
		if (A == null) {
			return 0;
		}
		int left = 1 + maxDepth(A.left);
		int right = 1 + maxDepth(A.right);
		return Math.max(left, right);
	}
}
