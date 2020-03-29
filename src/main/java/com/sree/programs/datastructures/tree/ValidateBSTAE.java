package com.sree.leave.programs.datastructures.tree;
/**
 * check below tushor roy vedio
 * https://www.youtube.com/watch?v=MILxfAbIhrE
 * @author sridharbattala
 *
 */
public class ValidateBSTAE {
	
	public static boolean validateBST(Node node,int minValue,int maxValue ) {
		
		if(!(minValue<node.data && node.data<maxValue)) {
			return false;
		}
		if(node.left!=null && !validateBST(node.left,minValue,node.data)) {
			return false;
		}
		if(node.right!=null && !validateBST(node.right,node.data,maxValue)) {
			return false;
		}
		return true;
	}
	
	
public static void main(String args[]) {
	Node node100=new Node(100);
	Node node50=new Node(50);
	Node node150=new Node(150);
	Node node25=new Node(25);
	Node node75=new Node(75);
	Node node30=new Node(30);
	Node node45=new Node(45);
	
	node100.left=node50;
	node100.right=node150;
	
	node50.left=node25;
	node50.right=node75;
	
	node25.left=node30;
	node25.right=node45;
	System.out.println(validateBST(node100,Integer.MIN_VALUE,Integer.MAX_VALUE));
}
}
