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
		int[] inOrder = { 2, 5, 6, 10, 12, 14, 15 };

		int[] preOrder = { 10, 5, 2, 6, 14, 12, 15 };
		Node x = makeBTree(inOrder, preOrder, 0, inOrder.length - 1);
		System.out.println("Constructed Tree : ");
		printINORDER(x);
	}

	public static int pIndex = 0;

	public static Node makeBTree(int[] inOrder, int[] preOrder, int iStart, int iEnd) {
		if (iStart > iEnd) {
			return null;
		}

		Node root = new Node(preOrder[pIndex]);
		pIndex++;
		if (iStart == iEnd) {
			return root;
		}

		int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
		root.left = makeBTree(inOrder, preOrder, iStart, index - 1);
		root.right = makeBTree(inOrder, preOrder, index + 1, iEnd);
		System.out.println("root=" + root.data + ", root.left=" + root.left.data + ", root.right=" + root.right.data);
		System.out.println("start=" + iStart + ", end=" + iEnd + ", index=" + index);
		return root;
	}

	public static int getInorderIndex(int[] inOrder, int start, int end, int data) {
		for (int i = start; i <= end; i++) {
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
