package com.sree.programs.important.leetcodetop75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphConnectedComponentCount {

	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static Set<Integer> visited = new HashSet<>();

	public static int connectedComponentCount(int vertices, int[][] edges) {
		// initialize graph
		for (int i = 0; i < vertices; i++) {
			graph.put(i, new LinkedList<>());
		}
		// build graph
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
		}
		int count = 0;
		for (int i = 0; i < vertices; i++) {
			if (!visited.contains(i)) {
				dfs(i);
				count++;
			}

		}
		return count;
	}

	private static void dfs(int currentVertex) {
		visited.add(currentVertex);
		for (Integer child : graph.get(currentVertex)) {
			if (!visited.contains(child)) {
				dfs(child);
			}
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		int result = connectedComponentCount(6, edges);
		System.out.println("output=" + result);
	}

}
