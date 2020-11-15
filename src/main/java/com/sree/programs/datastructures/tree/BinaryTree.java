package com.sree.programs.datastructures.tree;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
 * 
 * @author sbattala
 *
 */
public class BinaryTree {
	static int currentIndex = 0;

	public static void main(String[] args) {
		String[] preorder = { "1", "2", "3", null, null, "4", null, null, "5", null, null };
		TreeNode root = createBT(preorder);
		printPreorder(root);
		System.out.println();
		printPostorder(root);
	}

	public static TreeNode createBT(String[] preorder) {
		if (preorder[currentIndex] == null) {
			return null;
		} else {
			TreeNode root = new TreeNode(Integer.valueOf(preorder[currentIndex]));
			currentIndex++;
			root.left = createBT(preorder);
			currentIndex++;
			root.right = createBT(preorder);
			return root;
		}

	}

	public static void printPreorder(TreeNode root) {
		if (root == null) {
			System.out.print("null,");
			return;
		} else {
			System.out.print(root.data + ",");
			printPreorder(root.left);
			printPreorder(root.right);

		}

	}

	public static void printPostorder(TreeNode root) {
		if (root == null) {
			System.out.print("null,");
			return;
		} else {

			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root.data + ",");
		}

	}
}
