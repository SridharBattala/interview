package com.sree.programs.patterns.topologicalsort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class TaskScheduling {
public static void main(String[] args) {
	int[][] prerequisites1= {{0,1},{1,0},{2,1}};
	int tasks1=3;
	isSchedulePossible(prerequisites1,tasks1);
	int[][] prerequisites2= {{0,1},{1,2},{2,3}};
	int tasks2=4;
	isSchedulePossible(prerequisites2,tasks2);
}

private static void isSchedulePossible(int[][] edges,int totalVertices) {
	Map<Integer,List<Integer>> graph=new HashMap<>();
	Map<Integer,Integer> inDegree=new HashMap<>();
	//intilize values
	for(int i=0;i<totalVertices;i++) {
		graph.put(i, new LinkedList<>());
		inDegree.put(i,0 );
	}
	//build graph
	for(int i=0;i<edges.length;i++) {
		int parent=edges[i][0];
		int child=edges[i][1];
		graph.get(parent).add(child);
		inDegree.put(child, inDegree.get(child)+1);
	}
	//add sources to queue
	Queue<Integer> queue=new LinkedList<>();
	for(Entry<Integer, Integer> entry:inDegree.entrySet()) {
		if(entry.getValue()==0) {
			queue.add(entry.getKey());
		}
	}
	List<Integer> sortOrder=new LinkedList<>();
	while(!queue.isEmpty()) {
		Integer current=queue.poll();
		sortOrder.add(current);
		List<Integer> childs=graph.get(current);
		for(Integer child:childs) {
			inDegree.put(child, inDegree.get(child)-1);
			if(inDegree.get(child)==0) {
				queue.add(child);
			}
		}
	}
	System.out.println("scheduling= "+(sortOrder.size()==totalVertices));
		
	
}
}
