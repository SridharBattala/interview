package com.sree.programs.patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {
	private static class Node{
		public int data;
		public Node left;
		public Node right;
		Node(int data){
			this.data=data;
		}
	}
public static void main(String args[]) {
	Node node1=new Node(1);
	Node node2=new Node(2);
	Node node3=new Node(3);
	Node node4=new Node(4);
	Node node5=new Node(5);
	Node node6=new Node(6);
	Node node7=new Node(7);
	node1.left=node2;
	node1.right=	node3;
	node2.left=node4;
	node2.right=node5;
	node3.left=node6;
	//node6.left=node7;
	System.out.println("height="+findHeight(node1));
}
private static int findHeight(Node root) {
	//define queue
	Queue<Node> queue=new LinkedList<>();
	//add root 
	queue.add(root);
	//take intial height as 0
	int height=0;
	//loop queue untils its empty
	while(!queue.isEmpty()) {
		
		height++;
		int levelSize=queue.size();
		//loop all nodes in current level
		for(int i=0;i<levelSize;i++) {
			Node currentNode=queue.poll();
			//add left child
			if(currentNode.left!=null) {
				queue.add(currentNode.left);
			}
			//add right child
			if(currentNode.right!=null) {
				queue.add(currentNode.right);
			}
		}
	}
	return height;
}
}
