package com.sree.programs.datastructures.graph;

import java.util.*;

public class CheckMotherVertex {
	static Map<Integer, List<Integer>> map = new HashMap<>();
	static List<Integer> visited = new ArrayList<>();

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 0 }, { 3, 1 } };
		System.out.println("Mother vertex=" + findMotherVetex(4, edges));

	}

	private static int findMotherVetex(int vertices, int[][] edges) {

		// Initialize the graph
		for (int i = 0; i < vertices; i++) {
			map.put(i, new ArrayList<>());
		}
		// build graph
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
		}
		int lastVisitedVertex = 0;
		// this for loop is for disconnected graph
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (!visited.contains(vertex)) {
				dfs(vertex);
				lastVisitedVertex = vertex;
			}
		}

		System.out.println(map);
		System.out.println("lastVisitedVertex=" + lastVisitedVertex);
		// If there exist mother vertex (or vetices) in given
		// graph, then lastV must be one (or one of them)

		// Now check if lastV is actually a mother vertex (or graph
		// has a mother vertex). We basically check if every vertex
		// is reachable from lastV or not.

		// Reset all values in visited[] as false and do
		// DFS beginning from lastV to check if all vertices are
		// reachable from it or not.
		visited.clear();
		dfs(lastVisitedVertex);
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (!visited.contains(vertex)) {
				return -1;
			}
		}
		return lastVisitedVertex;
	}

	private static void dfs(int currentVertex) {
		visited.add(currentVertex);
		// get neighbors
		for (Integer vertex : map.get(currentVertex)) {
			if (!visited.contains(vertex)) {
				dfs(vertex);
			}
		}
	}
}
