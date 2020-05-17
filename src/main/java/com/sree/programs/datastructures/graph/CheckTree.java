package com.sree.programs.datastructures.graph;

import java.util.*;

public class CheckTree {
	public static void main(String args[]) {
		// graph should be connected
		// each vertex should have only one parent
		// no cycles in graph
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
		System.out.println("check tree=" + checkTree(edges, 6));
	}

	public static boolean checkTree(int[][] edges, int totalVertices) {
		// initialize graph
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < totalVertices; i++) {
			List<Integer> list = new LinkedList<>();
			graph.put(i, list);
		}
		// build graph
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			graph.get(parent).add(child);
		}
		// add root to queue
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		int visitedVertexCount = 1;
		// loop queue
		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			List<Integer> neighbors = graph.get(currentVertex);
			if (neighbors != null) {
				for (int neighbor : neighbors) {
					if (!visited.contains(neighbor)) {
						queue.offer(neighbor);
						visited.add(neighbor);
						visitedVertexCount++;
					} else {
						return false;
					}
				}
			}
		}
		// check for connected graph
		if (visitedVertexCount == totalVertices) {
			return true;
		} else {
			return false;
		}
	}
}
