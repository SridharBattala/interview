package com.sree.programs.important.leetcodetop75;

import java.util.*;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
 * 
 * inorder traversal will come as ascending order
 */
public class KthSmallest {
	public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
		if (root == null)
			return arr;
		inorder(root.left, arr);
		arr.add(root.data);
		inorder(root.right, arr);
		return arr;
	}

	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
		return nums.get(k - 1);
	}
}
