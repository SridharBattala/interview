package com.sree.programs.important.askedininterviews;

import java.util.*;

public class PaypalTransactionsGraph {
	static Set<Integer> visited = new HashSet<>();

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 1 }, { 1, 4 }, { 4, 5 }, { 7, 8 } };
		int minAmount = getMinAmount(edges);
		System.out.println("minAmount=" + minAmount);
	}
	// 1) initialize graph
	// 2)build graph
	// 3)traverse the graph using dfs and find how many vertices are there with out
	// degree 0
	// 4)return count of vertices with out degree 0

	private static int getMinAmount(int[][] edges) {
		// initialize graph
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			if (!graph.containsKey(edges[i][0])) {
				graph.put(edges[i][0], new LinkedList<>());
			}
			if (!graph.containsKey(edges[i][1])) {
				graph.put(edges[i][1], new LinkedList<>());
			}

		}
		// build graph
		for (int i = 0; i < edges.length; i++) {
			// add neighbor
			graph.get(edges[i][0]).add(edges[i][1]);

		}
		// dfs
		int count = 0;
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				System.out.println("start=" + entry.getKey());
				int tempCount = dfsHelper(graph, entry.getKey());
				System.out.println("tempCount=" + tempCount);
				count = count + tempCount;
			}

		}
		return count;
	}

	private static int dfsHelper(Map<Integer, List<Integer>> graph, int currentVertex) {
		visited.add(currentVertex);
		List<Integer> neighbors = graph.get(currentVertex);
		int count = 0;
		if (neighbors.isEmpty()) {
			// System.out.println("empty=" + currentVertex);
			count++;
			return count;
		} else {
			for (Integer neighbor : neighbors) {
				if (!visited.contains(neighbor)) {
					count = count + dfsHelper(graph, neighbor);
				}
			}
			// System.out.println(" current vertex=" + currentVertex + " count=" + count);
			return count;
		}

	}
}
