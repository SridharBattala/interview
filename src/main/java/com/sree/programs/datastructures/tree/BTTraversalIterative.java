package com.sree.programs.datastructures.tree;

/**
 * https://www.educative.io/courses/coderust-hacking-the-coding-interview/mZlv3
 * 
 * @author sbattala
 *
 */
import java.util.*;

public class BTTraversalIterative {
	static int currentIndex = 0;

	public static void main(String[] args) {
		String[] preorder = { "1", "2", "3", null, null, "4", null, null, "5", null, null };
		TreeNode root = BinaryTree.createBT(preorder);
		printPreorder(root);
		System.out.println();
		printInorder(root);
		System.out.println();
		printPostorder(root);
	}

	static void printInorder(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.empty() || root != null) {

			if (root != null) {
				stack.push(root);
				root = root.left;
				continue;
			}
			System.out.print(stack.peek().data + " ");
			root = stack.pop().right;
		}
	}

	static void printPreorder(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.empty() || root != null) {

			if (root != null) {
				stack.push(root);
				System.out.print(stack.peek().data + " ");
				root = root.left;
				continue;
			}
			root = stack.pop().right;
		}
	}

	static void printPostorder(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.empty() || root != null) {

			if (root != null) {
				stack.push(root);
				root = root.left;
				continue;
			}

			TreeNode temp = stack.peek().right;
			if (temp == null) {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				while (!stack.isEmpty() && temp == stack.peek().right) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
				}
			} else {
				root = temp;
			}

		}
	}
}
