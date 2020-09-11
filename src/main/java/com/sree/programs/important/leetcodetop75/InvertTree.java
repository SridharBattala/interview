package com.sree.programs.important.leetcodetop75;

public class InvertTree {
	public static void main(String args[]) {
		TreeNode TreeNode1 = new TreeNode(1);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);

		TreeNode1.left = TreeNode2;
		TreeNode1.right = TreeNode5;
		TreeNode2.left = TreeNode3;
		TreeNode2.right = TreeNode4;

		InvertTree object = new InvertTree();
		TreeNode root = object.invertTree(TreeNode1);
		System.out.println(" root.data=" + root.data);

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}
}
