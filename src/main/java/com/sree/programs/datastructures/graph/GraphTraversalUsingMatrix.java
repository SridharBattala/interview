package com.sree.programs.datastructures.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * https://www.educative.io/courses/data-structures-in-java-an-interview-refresher/qVA0EqnQy47
 */
public class GraphTraversalUsingMatrix {
public static void main(String args[]) {
int [][] matrix={{0,1,1,0,0},
						{0,0,0,1,1},
						{0,0,0,0,0},
						{0,0,0,0,0},
						{0,0,0,0,0}};
//dfs(matrix);
//dfsRecursive(matrix);
dfsPrintAllPaths(matrix);
}
private static void dfsPrintAllPaths(int[][] matrix) {
	int rowSize=matrix.length;
	int colSize=matrix[0].length;
	Set<Integer> visitedSet=new HashSet<>();
	Set<Integer> localPaths=new HashSet<>();
	helperPrintAllPaths(matrix,rowSize,colSize,visitedSet,0,localPaths);
	
}
private static void helperPrintAllPaths(int[][] matrix, int rowSize, int colSize, Set<Integer> visitedSet, int current,Set<Integer> localPaths) {
	visitedSet.add(current);
	System.out.print(current+"-->");

	if(visitedSet.size()==rowSize) {
		
		System.out.println("ssss");
		return;
	}else {
		//adding child's
		for(int i=0;i<colSize;i++) {
			if(matrix[current][i]==1 && !visitedSet.contains(i)) {	
				helperPrintAllPaths(matrix,rowSize, colSize,visitedSet,  i,localPaths);
			}		
		}		
	}
	visitedSet.remove(current);
	//localPaths.remove(current);
}
private static void bfs(int[][] matrix) {
	int rowSize=matrix.length;
	int colSize=matrix[0].length;
	Queue<Integer> queue=new LinkedList<>();
	queue.add(0);
	Set<Integer> visitedSet=new HashSet<>();
	while(!queue.isEmpty()) {
		int current=queue.poll();
		System.out.println(current);
		
		//adding child's
		for(int i=0;i<colSize;i++) {
			if(matrix[current][i]==1 && !visitedSet.contains(current)) {
				queue.add(i);
			}
		}
		visitedSet.add(current);
	}
	
	
}


private static void dfs(int[][] matrix) {
	int rowSize=matrix.length;
	int colSize=matrix[0].length;
	Stack<Integer> stack=new Stack<>();
	stack.add(0);
	Set<Integer> visitedSet=new HashSet<>();
	while(!stack.isEmpty()) {
		int current=stack.pop();
		System.out.println(current);
		
		//adding child's
		for(int i=0;i<colSize;i++) {
			if(matrix[current][i]==1 && !visitedSet.contains(current)) {
				stack.push(i);
			}
		}
		visitedSet.add(current);
	}

}
private static void dfsRecursive(int[][] matrix) {
	int rowSize=matrix.length;
	int colSize=matrix[0].length;
	Set<Integer> visitedSet=new HashSet<>();
	List<Integer> path=new LinkedList<>();
	helper(matrix,rowSize,colSize,visitedSet,0,path);
	for(int node:path) {
		System.out.println(node);
	}
}
private static List<Integer> helper(int[][] matrix,int rowSize,int colSize,Set<Integer> visitedSet, int current,List<Integer> path){
	visitedSet.add(current);
	path.add(current);

	if(visitedSet.size()==rowSize) {
		return path;
	}else {
		//adding child's
		for(int i=0;i<colSize;i++) {
			if(matrix[current][i]==1 && !visitedSet.contains(i)) {
				
				helper(matrix,rowSize, colSize,visitedSet,  i,path);
			}
			
		}
		return path;
	}
}

}
