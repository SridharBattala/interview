package com.sree.programs.patterns.topologicalsort;

import java.util.*;

class TopologicalSort {
	static Map<Integer, List<Integer>> map = new HashMap<>();
	static List<Integer> visited = new ArrayList<>();
	static Map<Integer, Integer> inDegree = new HashMap<>();

	public static List<Integer> sort(int vertices, int[][] edges) {
		// initialize graph
		for (int i = 0; i < vertices; i++) {
			map.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}
		// build graph
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			inDegree.put(edges[i][1], inDegree.get(edges[i][1]) + 1);
		}
		// start bfs
		Queue<Integer> queue = new LinkedList<>();
		// add all sources
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}
		List<Integer> topologicalSort = new ArrayList<>();
		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			topologicalSort.add(currentVertex);
			visited.add(currentVertex);
			// get neighbours
			for (Integer neighbor : map.get(currentVertex)) {
				if (!visited.contains(neighbor)) {
					inDegree.put(neighbor, inDegree.get(neighbor) - 1);
					if (inDegree.get(neighbor) == 0) {
						queue.add(neighbor);
					}

				}
			}
		}
		// having cycle
		if (topologicalSort.size() != vertices) {
			return new ArrayList<>();
		}
		return topologicalSort;
	}

	public static void main(String[] args) {
		int[][] edges = { { 3, 2 }, { 3, 0 }, { 2, 0 }, { 2, 1 } };
		List<Integer> result = TopologicalSort.sort(4, edges);
		System.out.println("output=" + result);
	}
}
