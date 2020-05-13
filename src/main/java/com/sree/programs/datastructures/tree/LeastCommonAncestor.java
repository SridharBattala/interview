package com.sree.programs.datastructures.tree;

public class LeastCommonAncestor {
	// driver method
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
		TreeNode lca = findLCA(TreeNode1, 6, 5);// recursive method
		System.out.println("lca=" + lca.data);
	}

	private static TreeNode findLCA(TreeNode currentTreeNode, int data1, int data2) {
		// base case 1
		if (currentTreeNode == null) {
			return null;
		} else if (currentTreeNode.data == data1 || currentTreeNode.data == data2) {
			return currentTreeNode;
		}
		// recursive case
		else {
			TreeNode left = findLCA(currentTreeNode.left, data1, data2);
			TreeNode right = findLCA(currentTreeNode.right, data1, data2);
			if (left != null && right != null) {
				return currentTreeNode;
			} else if (left != null) {
				return left;
			} else {
				return right;
			}
		}
	}

}
