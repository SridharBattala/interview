package com.sree.programs.datastructures.graph;

/*
 * https://www.interviewbit.com/problems/commutable-islands/
 */
import java.util.*;

public class CommutableIslands {
	static int minDistance = Integer.MAX_VALUE;
	static int currentDistance = 0;

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

		edges.add(new Edge(1, 2, 1));
		edges.add(new Edge(2, 3, 3));
		edges.add(new Edge(1, 4, 3));
		edges.add(new Edge(4, 3, 2));
		edges.add(new Edge(1, 3, 10));
		edges.add(new Edge(3, 4, 1));

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
		for (Map.Entry<Integer, List<Edge>> entry : graph.entrySet()) {

			visitedList.add(entry.getKey());

			// find min distance
			helper(graph, edges, visitedList);
			// finalize result
			if (visitedList.size() == graph.size() && minDistance > currentDistance) {
				minDistance = currentDistance;
				// print MST
				for (Edge edge : edges) {
					if (edge.visited) {
						System.out.println("MST=" + edge);
					}
				}
			}
			// make edges unvisited
			for (Edge edge : edges) {
				edge.visited = false;
			}

			visitedList.clear();
			currentDistance = 0;
		}

		System.out.println("minDistance=" + minDistance);

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
				currentDistance = currentDistance + smallest.distance;
			} else {
				break;
			}

		}
	}
}
