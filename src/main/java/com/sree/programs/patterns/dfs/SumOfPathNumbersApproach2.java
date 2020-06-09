package com.sree.programs.patterns.dfs;

import com.sree.programs.patterns.dfs.TreePathSum.TreeNode;
//         1
//   0          1
//1          6    5
import java.util.*;

public class SumOfPathNumbersApproach2 {
	static List<TreeNode> callStack = new LinkedList<>();

	public static int findSumOfPathNumbers(TreeNode currentNode) {
		return helper(currentNode);
	}

	static int totalSum = 0;

	public static int helper(TreeNode currentNode) {
		if (currentNode == null) {
			return 0;
		} else {
			callStack.add(currentNode);
			if (currentNode.left == null && currentNode.right == null) {
				int sum = 0;
				int size = callStack.size() - 1;
				for (TreeNode node : callStack) {
					sum = sum + (node.val * (int) Math.pow(10, size));
					size--;
				}
				totalSum = totalSum + sum;
			} else {
				helper(currentNode.left);
				helper(currentNode.right);
			}

			callStack.remove(currentNode);
			return totalSum;
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbersApproach2.findSumOfPathNumbers(root));
	}
}