package com.sree.programs.datastructures.graph;

/**
 * https://algorithms.tutorialhorizon.com/check-if-graph-is-bipartite-adjacency-list-using-depth-first-searchdfs
 * 
 * @author sbattala
 *
 */
import java.util.*;

public class CheckBipartiteGraph {
	static enum Color {
		WHITE, RED, GREEN
	}

	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static Map<Integer, Color> colorMap = new HashMap<>();
	static int vertexCount = 4;

	public static void main(String[] args) {
		int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 3 }, { 3, 1 } };

		int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 1 } };

		System.out.println("Bipartite=" + checkBipartite(edges1, vertexCount));
		System.out.println("Bipartite=" + checkBipartite(edges2, vertexCount));

	}

	private static boolean checkBipartite(int[][] edges, int vertexCount) {
		// add vertices to the graph
		for (int vertex = 0; vertex < vertexCount; vertex++) {
			graph.put(vertex, new LinkedList<>());
		}
		// add edges to the graph
		for (int index = 0; index < edges.length; index++) {
			// bidirectional graph
			graph.get(edges[index][0]).add(edges[index][1]);
			graph.get(edges[index][1]).add(edges[index][0]);
		}
		// add white color to all the vertices
		for (int vertex = 0; vertex < vertexCount; vertex++) {
			colorMap.put(vertex, Color.WHITE);
		}
		// traverse graph
		for (int vertex = 0; vertex < vertexCount; vertex++) {
			if (!dfs(vertex)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int vertex) {

		if (Color.WHITE.equals(colorMap.get(vertex))) {
			colorMap.put(vertex, Color.RED);
		}

		Color currentVertexColor = colorMap.get(vertex);
		// traverse neighbors
		for (Integer neighbor : graph.get(vertex)) {
			if (Color.WHITE.equals(colorMap.get(neighbor))) {
				if (Color.RED.equals(currentVertexColor)) {
					colorMap.put(neighbor, Color.GREEN);
				} else if (Color.GREEN.equals(currentVertexColor)) {
					colorMap.put(neighbor, Color.RED);
				}
				// recursive call
				dfs(neighbor);
			} else if (colorMap.get(neighbor) == currentVertexColor) {
				return false;
			}

		}

		return true;

	}
}
