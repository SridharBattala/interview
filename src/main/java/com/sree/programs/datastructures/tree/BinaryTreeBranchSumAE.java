package com.sree.leave.programs.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * check AE only
 */
public class BinaryTreeBranchSumAE {
	
	
	private static class BinaryTree {
	    int value;
	    BinaryTree left;
	    BinaryTree right;

	    BinaryTree(int value) {
	      this.value = value;
	      this.left = null;
	      this.right = null;
	    }
	  }

  // O(n) time | O(n) space - where n is the number of nodes in the Binary Tree
  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer> sums = new ArrayList<Integer>();
    calculateBranchSums(root, 0, sums);
    return sums;
  }

  public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
    if (node == null) return;

    int newRunningSum = runningSum + node.value;
    if (node.left == null && node.right == null) {
      sums.add(newRunningSum);
      return;
    }

    calculateBranchSums(node.left, newRunningSum, sums);
    calculateBranchSums(node.right, newRunningSum, sums);
  }
}
