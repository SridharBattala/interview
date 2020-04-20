package com.sree.programs.patterns.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
private static class Node{
	public Node left;
	public Node right;
	public int value;
	Node(int value){
		this.value=value;
	}
}
public static void main(String args[]) {
	Node node1=new Node(1);
	Node node7=new Node(7);
	Node node4=new Node(4);
	Node node5=new Node(5);
	Node node9=new Node(9);
	Node node2=new Node(2);
	Node node71=new Node(7);
	node1.left=node7;
	node1.right=	node9;
	node7.left=node4;
	node7.right=	node5;
	node9.left=node2;
	node9.right=	node71;
	List<Integer> currentPath=new ArrayList<>();
	List<List<Integer>> result=new ArrayList<>();
	helper(node1,0,12,currentPath,result);
	//print
	for(List<Integer> path:result) {
		System.out.println(path.toString());
	}
}
private static void helper(Node currentNode,int currentSum,int targetSum,List<Integer> currentPath,List<List<Integer>> result) {
	if(currentNode==null) {
		return;
	}
	currentPath.add(currentNode.value);
	currentSum=currentSum+currentNode.value;
	if(currentSum==targetSum && currentNode.left == null && currentNode.right == null) {
		result.add(new ArrayList<>(currentPath));
	}
	
	
	helper(currentNode.left,currentSum,targetSum,currentPath,result);
	helper(currentNode.right,currentSum,targetSum,currentPath,result);
	
	currentPath.remove(currentPath.size() - 1);
}
}
