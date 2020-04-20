package com.sree.programs.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphCycle {
public static void main(String args[]) {
	int totalVertices=5;
	int[][] edges= {{0,1},{0,2},{1,3},{3,4},{3,0},{4,2}};
	checkCycle(totalVertices,edges);
}
/**
 * driver method
 */
private static void checkCycle(int totalVertices, int[][] edges) {
	Map<Integer,List<Integer>> graph=new HashMap<>(totalVertices);
	//initilaize graph
	for(int i=0;i<totalVertices;i++) {
		graph.put(i, new ArrayList<>());
	}
	//build graph
	for(int i=0;i<edges.length;i++) {
		int parent=edges[i][0];
				int child=edges[i][1];
		graph.get(parent).add(child);
	}
	boolean isCycleExists=helper(graph,0,new HashSet<>(),new HashSet<>());
	System.out.println("isCycleExists="+isCycleExists);
}
/**
 * recursive method
 * @param graph
 * @param currentVetex
 * @param visited
 * @param currentStack
 * @return
 */
private static boolean helper(Map<Integer, List<Integer>> graph,int currentVetex,Set<Integer> visited,Set<Integer> currentStack) {
	
	//base case 1
	if(currentStack.contains(currentVetex)) {
		return true;
	}
	//base case 2
	else if(visited.contains(currentVetex)) {
		return false;
	}
	//recursive case
	else {
		//add current vertex to visited set
		visited.add(currentVetex);
		//add current vertex to currentStack
		currentStack.add(currentVetex);
		//call helper method for current vertex neighbors 
		for(int neighbor:graph.get(currentVetex)) {
			boolean cycleExists=helper(graph,neighbor,visited,currentStack);
			//if cycle exists return true
			if(cycleExists) {
				return true;
			}
		}
		//once all the recursive calls over for current vertex, remove from currentStack
		currentStack.remove(currentVetex);
		return false;
	}
	
	
}

}
