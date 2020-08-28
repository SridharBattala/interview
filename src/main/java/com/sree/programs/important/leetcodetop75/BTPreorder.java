package com.sree.programs.important.leetcodetop75;

/**
 * https://algorithms.tutorialhorizon.com/make-a-binary-tree-from-given-inorder-and-preorder-traveral/
 * 
 * @author sbattala
 *
 */
public class BTPreorder {
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
		int[] inOrder = { 2, 5, 6, 10, 12, 14, 15 };
		int[] preOrder = { 10, 5, 2, 6, 14, 12, 15 };
		Node x = makeBTree(preOrder);
		System.out.println("PreOrder Tree : ");
		printPreOrder(x);
		System.out.println();
		System.out.println("InOrder Tree : ");
		printInOrder(x);
	}

	public static int pIndex = 0;

	public static Node makeBTree(int[] preOrder) {
		if (pIndex > preOrder.length - 1) {
			return null;
		}
		Node root = new Node(preOrder[pIndex]);
		pIndex++;
		root.left = makeBTree(preOrder);
		root.right = makeBTree(preOrder);
		// System.out.println("root=" + root.data + ", root.left=" + root.left.data + ",
		// root.right=" + root.right.data);
		return root;
	}

	public static void printPreOrder(Node root) {
		if (root != null) {
			System.out.print("  " + root.data);
			printPreOrder(root.left);

			printPreOrder(root.right);
		}
	}

	public static void printInOrder(Node root) {
		if (root != null) {

			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}
}
