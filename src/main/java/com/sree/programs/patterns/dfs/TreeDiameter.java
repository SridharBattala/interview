package com.sree.programs.patterns.dfs;

import java.util.*;

public class TreeDiameter {
	static int diameter = 0;
	static LinkedList<Integer> finalStack = new LinkedList<>();
	static LinkedList<Integer> currentStack = new LinkedList<>();
	static LinkedList<Integer> leftStack = new LinkedList<>();
	static LinkedList<Integer> rightStack = new LinkedList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		// System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
		// System.out.println("Tree Diameter elemnets: " + finalStack.toString());
		root.left.left = null;
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.left.right.left = new TreeNode(10);
		root.right.right.left.left = new TreeNode(11);
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
		System.out.println("Tree Diameter elemnets: " + finalStack.toString());
	}

	private static int findDiameter(TreeNode root) {
		diameter = 0;
		finalStack.clear();
		leftStack.clear();
		rightStack.clear();
		currentStack.clear();
		findDiameterRecursive(root, null);

		return diameter;
	}

	private static int findDiameterRecursive(TreeNode root, String direction) {
		System.out.println("currentStack=" + currentStack.toString());
		if (root == null) {
			return 0;
		} else {
			int currentHeight = 0;
			if (direction == "left") {
				leftStack.add(root.val);
			} else if (direction == "right") {
				rightStack.add(root.val);
			} else {
				currentStack.add(root.val);
			}

			int leftHeight = findDiameterRecursive(root.left, "left");
			int rightHeight = findDiameterRecursive(root.right, "right");
			System.out.println("left stack for " + root.val + " =" + leftStack.toString());
			System.out.println("right stack for " + root.val + " =" + rightStack.toString());
			currentHeight = 1 + leftHeight + rightHeight;
			if (leftHeight > rightHeight) {
				currentStack.addAll(new LinkedList<>(leftStack));
				leftStack.clear();
			} else if (leftHeight < rightHeight) {
				currentStack.addAll(new LinkedList<>(rightStack));
				rightStack.clear();
			}

			diameter = Math.max(diameter, currentHeight);
			if (currentHeight > diameter) {
				finalStack = new LinkedList<>(currentStack);
			}

			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
