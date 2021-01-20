package com.sree.programs.important.leetcodetop75;

/**
 * https://algorithms.tutorialhorizon.com/make-a-binary-tree-from-given-inorder-and-preorder-traveral/
 * 
 * @author sbattala
 *
 */
public class BTInorderPreorder {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String args[]) {
		int[] inOrder = { 9, 3, 15, 20, 7 };

		int[] preOrder = { 3, 9, 20, 15, 7 };
		Node x = makeBTree(inOrder, preOrder, 0, inOrder.length - 1);
		System.out.println("Constructed Tree : ");
		printINORDER(x);
	}

	public static int pIndex = 0;

	public static Node makeBTree(int[] inOrder, int[] preOrder, int inOrderStart, int inOrderEnd) {
		// base case 1
		if (inOrderStart > inOrderEnd) {
			return null;
		}

		Node root = new Node(preOrder[pIndex]);
		pIndex++;

		// recursive case
		int index = getInorderIndex(inOrder, root.data);
		root.left = makeBTree(inOrder, preOrder, inOrderStart, index - 1);
		root.right = makeBTree(inOrder, preOrder, index + 1, inOrderEnd);

		return root;
	}

	public static int getInorderIndex(int[] inOrder, int data) {
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public static void printINORDER(Node root) {
		if (root != null) {
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}
}
