package com.sree.programs.important.leetcodetop75;

public class SubTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		String tree1 = preorder(s);
		String tree2 = preorder(t);
		return tree1.indexOf(tree2) >= 0;
	}

	public String preorder(TreeNode t) {
		if (t == null) {
			return "null";
		}
		return "#" + t.data + " " + preorder(t.left) + " " + preorder(t.right);
	}
}
