package com.sree.programs.datastructures.tree;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/YQ5o5vEXP69
 */
import java.util.*;

public class RootToLeafPathsSum {
	static int count = 0;

	public static void main(String[] args) {
		String[] preOrder = { "1", "7", null, null, "9", "2", null, null, "9", null, null };
		TreeNode root = BinaryTree.createBT(preOrder);
		LinkedList<Integer> callStack = new LinkedList<Integer>();

		rootToLeafPathsSum(root, callStack);
		System.out.println("count=" + count);
	}

	private static void rootToLeafPathsSum(TreeNode root, LinkedList<Integer> callStack) {
		if (root == null) {
			return;
		} else {
			callStack.add(root.data);
			if (root.left == null && root.right == null) {
				String number = "";
				for (int num : callStack) {
					number = number + num;
				}
				System.out.println(number);
				count = count + Integer.valueOf(number);

			}
			rootToLeafPathsSum(root.left, callStack);
			rootToLeafPathsSum(root.right, callStack);
			callStack.removeLast();
		}

	}
}
