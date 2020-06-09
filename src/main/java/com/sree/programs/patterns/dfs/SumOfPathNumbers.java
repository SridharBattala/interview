package com.sree.programs.patterns.dfs;

import com.sree.programs.patterns.dfs.TreePathSum.TreeNode;
//         1
//   0          1
//1          6    5
import java.util.*;

public class SumOfPathNumbers {
	public static int findSumOfPathNumbers(TreeNode currentNode) {
		return helper(currentNode, 0);
	}

	public static int helper(TreeNode currentNode, int pathSum) {
		// base case1
		// return 0 for null node
		if (currentNode == null) {
			return 0;
		}
		// base case2
		// return path for leaf node
		else if (currentNode.left == null && currentNode.right == null) {
			return (pathSum * 10) + currentNode.val;
		} else {
			int leftValue = helper(currentNode.left, (pathSum * 10) + currentNode.val);
			System.out.println("leftValue=" + leftValue);
			int rightValue = helper(currentNode.right, (pathSum * 10) + currentNode.val);
			return leftValue + rightValue;

		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}
}