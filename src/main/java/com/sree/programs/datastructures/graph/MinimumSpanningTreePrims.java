package com.sree.programs.datastructures.graph;

/*
 * https://www.educative.io/courses/coderust-hacking-the-coding-interview/j2rp5
 */
import java.util.*;

public class MinimumSpanningTreePrims {
	static int minDistance = 0;

	static class Edge {
		int source;
		int dest;
		int distance;
		boolean visited;

		Edge(int source, int dest, int distance) {
			this.source = source;
			this.dest = dest;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "[" + source + "," + dest + "," + distance + "]";
		}
	}

	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();

		edges.add(new Edge(1, 4, 2));
		edges.add(new Edge(1, 3, 1));
		edges.add(new Edge(1, 2, 2));
		edges.add(new Edge(3, 4, 1));
		edges.add(new Edge(2, 4, 3));
		edges.add(new Edge(3, 5, 2));
		edges.add(new Edge(4, 7, 2));
		edges.add(new Edge(5, 6, 1));
		edges.add(new Edge(5, 7, 2));

		Map<Integer, List<Edge>> graph = new HashMap<>();
		// add all vertex
		for (int i = 0; i < edges.size(); i++) {
			graph.put(edges.get(i).source, new ArrayList<>());
			graph.put(edges.get(i).dest, new ArrayList<>());
		}
		// add all edges
		for (int i = 0; i < edges.size(); i++) {
			graph.get(edges.get(i).source).add(edges.get(i));

		}
		System.out.println("graph=" + graph.toString());
		List<Integer> visitedList = new ArrayList<>();
		visitedList.add(edges.get(0).source);
		// find min distance
		helper(graph, edges, visitedList);
		System.out.println("minDistance=" + minDistance);
		// print MST
		for (Edge edge : edges) {
			if (edge.visited) {
				System.out.println("MST=" + edge);
			}
		}

	}

	private static void helper(Map<Integer, List<Edge>> graph, List<Edge> edges, List<Integer> visitedList) {

		while (visitedList.size() < graph.size()) {
			Edge smallest = null;
			// find smallest distance edge from visited vertex
			for (Edge edge : edges) {
				if (visitedList.contains(edge.source) && !visitedList.contains(edge.dest)) {
					if (smallest == null || edge.distance < smallest.distance) {
						smallest = edge;
					}
				}
			}
			if (smallest != null) {
				// make edge as visited
				smallest.visited = true;
				// make vertex as visited
				visitedList.add(smallest.dest);
				minDistance = minDistance + smallest.distance;
			} else {
				break;
			}

		}
	}
}
