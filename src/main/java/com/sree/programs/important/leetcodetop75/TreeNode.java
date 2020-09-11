package com.sree.programs.important.leetcodetop75;


class TreeNode {
    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    public static TreeNode createNode(final int number) {
        return new TreeNode(number);
    }
}
