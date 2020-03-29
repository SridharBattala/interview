package com.sree.leave.programs.datastructures.tree;


class Node {
    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }

    public int data;
    public Node left;
    public Node right;

    public Node(final int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.left = null;
        this.right = null;
    }

    public static Node createNode(final int number) {
        return new Node(number);
    }
}
