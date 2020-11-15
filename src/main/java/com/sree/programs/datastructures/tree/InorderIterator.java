package com.sree.programs.datastructures.tree;

import java.util.*;

public class InorderIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public static void main(String[] args) {
		String[] preorder = { "1", "2", "3", null, null, "4", null, null, "5", null, null };
		TreeNode root = BinaryTree.createBT(preorder);
		System.out.print("Inorder Iterator = ");
		System.out.println(inorderUsingIterator(root));
	}

	public InorderIterator(TreeNode root) {
		populateIterator(root);
	}

	public void populateIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public TreeNode getNext() {
		if (stack.isEmpty())
			return null;

		TreeNode rVal = stack.pop();
		TreeNode temp = rVal.right;
		populateIterator(temp);

		return rVal;
	}

	public static String inorderUsingIterator(TreeNode root) {
		InorderIterator iter = new InorderIterator(root);
		String result = "";
		while (iter.hasNext()) {
			result += iter.getNext().data + " ";
		}
		return result;
	}
}
