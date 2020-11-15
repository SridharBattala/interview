package com.sree.programs.datastructures.graph;

import java.util.*;

public class GraphPrintAllPaths {
	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 0 }, { 0, 4 }, { 0, 3 }, { 1, 2 }, { 4, 2 }, { 3, 2 } };

		printPaths(edges, 0, 2);
	}

	private static void printPaths(int[][] edges, int source, int destination) {
		// add all vertex
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			graph.put(edges[i][0], new ArrayList<>());
			graph.put(edges[i][1], new ArrayList<>());
		}
		// add all edges
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);

		}
		System.out.println("graph=" + graph.toString());
		LinkedList<Integer> visited = new LinkedList<>();
		visited.add(source);
		helper(graph, source, destination, visited);
	}

	private static void helper(Map<Integer, List<Integer>> graph, int source, int destination,
			LinkedList<Integer> visited) {
		if (source == destination) {
			System.out.println("path=" + visited.toString());
		}
		List<Integer> childs = graph.get(source);
		for (int child : childs) {
			if (!visited.contains(child)) {
				visited.add(child);
				helper(graph, child, destination, visited);
				visited.removeLast();
			}

		}

	}
}
