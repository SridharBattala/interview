package com.sree.programs.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceBetweenTwoVertices {
public static void main(String[] args) {
	//test case 1
	int totalVertices=5;
	int[][] edges= new int[][]{{0,1},{0,2},{0,3},{1,3},{2,3},{3,4}};
	int minDistance=getMinDistance(totalVertices,edges,0,4);
	System.out.println("min distance="+minDistance);
	//test case 2
	totalVertices=7;
	edges= new int[][]{{0,1},{0,2},{0,4},{1,3},{2,4},{3,5},{4,5},{5,6}};
	minDistance=getMinDistance(totalVertices,edges,0,6);
	System.out.println("min distance="+minDistance);
}

private static int getMinDistance(int totalVertices, int[][] edges,int startVertex,int endVertex) {
	//define graph
	Map<Integer,List<Integer>> graph=new HashMap<>();
	//initialize graph
	for(int i=0;i<totalVertices;i++) {
		graph.put(i, new LinkedList<>());
	}
	//build graph
	for(int i=0;i<edges.length;i++) {
		graph.get(edges[i][0]).add(edges[i][1]);
	}
	//define distance map of vertex to distance
	Map<Integer,Integer> distanceMap=new HashMap<>();
	//define visited set
	Set<Integer> visited=new HashSet<>();
	visited.add(startVertex);
	//define queue
	Queue<Integer> queue=new LinkedList<>();
	//add source to queue
	queue.add(startVertex);
	
	distanceMap.put(startVertex,0);
	//loop queue until its empty
	while(!queue.isEmpty()) {
		System.out.println(distanceMap);
		int currentVertex=queue.poll();
		//loop neighbors
		for(int neighbor:graph.get(currentVertex)) {
			if(!visited.contains(neighbor)) {
				queue.add(neighbor);
				visited.add(neighbor);
				//update distance for neighbor
				distanceMap.put(neighbor,1+distanceMap.getOrDefault(currentVertex,0));
					
				//check neighbor is end vertex
				if(neighbor==endVertex) {
					return distanceMap.getOrDefault(neighbor,0);
				}
			}
			
		}
	}
	return -1;
}
}
