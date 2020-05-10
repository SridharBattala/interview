package com.sree.programs.datastructures.tree;

public class LeastCommonAncestor {
	//driver method
	public static void main(String args[]) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.left=node2;
		node1.right=	node3;
		node2.left=node4;
		node2.right=node5;
		node4.left=node6;
		node4.right=node7;
		Node lca=findLCA(node1,6,5);//recursive method
		System.out.println("lca="+lca.data);
	}

	private static Node findLCA(Node currentNode,int data1,int data2) {
		//base case 1
		if(currentNode==null) {
			return null;
		}else if(currentNode.data==data1 || currentNode.data==data2) {
			return currentNode;
		}
		//recursive case
		else {
			Node left=findLCA(currentNode.left, data1, data2);
			Node right=findLCA(currentNode.right, data1, data2);
			if(left!=null && right!=null) {
				return currentNode;
			}else if(left!=null) {
				return left;
			}else {
				return right;
			}
		}
	}
	
}
