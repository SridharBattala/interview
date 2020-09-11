package com.sree.programs.datastructures.tree;

public class BinarySearchTreePractise {
	public static void main(String args[]) {
		TreeNode TreeNode1 = new TreeNode(1);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);
		TreeNode TreeNode6 = new TreeNode(6);
		TreeNode TreeNode7 = new TreeNode(7);
		TreeNode TreeNode8 = new TreeNode(8);
		TreeNode TreeNode9 = new TreeNode(9);
		TreeNode TreeNode10 = new TreeNode(10);
		/*
		 * 5 3 8 1 2 6 9 7 10
		 */
		// 5->3,7
		TreeNode5.left = TreeNode3;
		TreeNode5.right = TreeNode7;
		// 3->1,4
		TreeNode3.left = TreeNode1;
		TreeNode3.right = TreeNode4;
		// 7->6,9
		TreeNode7.left = TreeNode6;
		TreeNode7.right = TreeNode9;
		// 9->8,10
		TreeNode9.left = TreeNode8;
		TreeNode9.right = TreeNode10;

		// System.out.println(" Min element=" + getMinElement(TreeNode1));
		// System.out.println(" Height=" + getHeight(TreeNode5));
		System.out.println(" lca=" + lca(TreeNode5, 6, 8));
		System.out.println(" distanceFromRootToNode=" + distanceFromRootToNode(TreeNode5, 8));
		System.out.println(" search=" + searchNode(TreeNode5, 8).data);
	}

	private static TreeNode searchNode(TreeNode root, int nodeValue) {
		if (root == null) {
			return null;
		} else if (root.data == nodeValue) {
			return root;
		} else {
			TreeNode searchNode = null;
			if (root.data < nodeValue) {
				searchNode = searchNode(root.right, nodeValue);
			} else {
				searchNode = searchNode(root.left, nodeValue);
			}
			return searchNode;
		}
	}

	public static int lca(TreeNode root, int nodeValue1, int nodeValue2) {
		return lcaHelper(root, nodeValue1, nodeValue2);
	}

	private static int lcaHelper(TreeNode root, int nodeValue1, int nodeValue2) {
		if (root == null) {
			return 0;
		} else if (root.data == nodeValue1 || root.data == nodeValue2) {
			return root.data;
		} else {
			int lca = 0;
			if (root.data < nodeValue1 && root.data < nodeValue2) {
				lca = lcaHelper(root.right, nodeValue1, nodeValue2);

			} else if (root.data >= nodeValue1 && root.data >= nodeValue2) {
				lca = lcaHelper(root.left, nodeValue1, nodeValue2);
			} else {
				lca = root.data;
			}
			return lca;

		}

	}

	private static int distanceFromRootToNode(TreeNode root, int nodeValue) {
		return distanceFromRootToNodeHelper(root, nodeValue);
	}

	private static int distanceFromRootToNodeHelper(TreeNode root, int nodeValue) {
		if (root.data == nodeValue) {
			return 0;
		} else {
			int distance = 0;
			if (root.data < nodeValue) {
				distance = 1 + distanceFromRootToNodeHelper(root.right, nodeValue);
			} else {
				distance = 1 + distanceFromRootToNodeHelper(root.left, nodeValue);
			}
			return distance;
		}
	}

	public static int getHeight(TreeNode root) {
		return getHeightHelper(root);
	}

	public static int getHeightHelper(TreeNode root) {
		if (root == null) {
			return -1;
		} else {
			int leftHeight = getHeightHelper(root.left);
			int rightHeight = getHeightHelper(root.right);
			int height = Math.max(leftHeight, rightHeight) + 1;
			System.out.println("height of " + root.data + "= " + height);
			return height;
		}

	}

	public static int getMinElement(TreeNode root) {
		return getMinElemenHelper(root);
	}

	public static int getMinElemenHelper(TreeNode root) {
		if (root == null) {
			return -1;
		} else if (root != null && root.left == null && root.right == null) {
			return root.data;
		} else {
			return getMinElemenHelper(root.left);
		}

	}

}
