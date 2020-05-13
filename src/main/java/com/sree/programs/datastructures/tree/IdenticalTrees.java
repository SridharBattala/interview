package com.sree.programs.datastructures.tree;

import java.util.Arrays;
import java.util.*;

public class IdenticalTrees {
	public static void main(String args[]) {
		List<Integer> list1 = Arrays.asList(100, 200, 50, 25, 125, 350);
		List<Integer> list2 = Arrays.asList(100, 200, 50, 25, 125, 350);
		TreeNode root1 = BinarySearchTree.insert(list1);
		TreeNode root2 = BinarySearchTree.insert(list2);
		BinarySearchTree.displayLevelOrder(root1);
		BinarySearchTree.displayLevelOrder(root2);
		boolean identical = checkForIndentical(root1, root2);
		System.out.println("identical=" + identical);
	}

	// recursive method
	private static boolean checkForIndentical(TreeNode root1, TreeNode root2) {
		// base case 1
		if (root1 == null && root2 == null) {
			return true;
		}
		// base case 2
		else if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
			return false;
		}
		// base case 3
		else if (root1 != null && root2 != null && root1.data != root2.data) {
			return false;
		}
		// recursive case
		else {
			return checkForIndentical(root1.left, root2.left) && checkForIndentical(root1.right, root2.right);
		}
	}

}
