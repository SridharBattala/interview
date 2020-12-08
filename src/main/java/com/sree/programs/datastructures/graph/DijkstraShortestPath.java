package com.sree.programs.datastructures.graph;

import java.util.*;

/**
 * https://algorithms.tutorialhorizon.com/dijkstras-shortest-path-algorithm-spt-adjacency-list-and-priority-queue-java-implementation//
 * 
 * @author sbattala
 *
 */
public class DijkstraShortestPath {

	static Map<Integer, Integer> distanceMap = new LinkedHashMap<>();
	static Map<Integer, List<Edge>> graph = new HashMap<>();
	static List<Integer> visitedList = new ArrayList<>();
	static List<Edge> edges = new ArrayList<>();
	static PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
	static List<Edge> mst = new ArrayList<>();

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

		edges.add(new Edge(0, 1, 4));
		edges.add(new Edge(0, 2, 3));
		edges.add(new Edge(1, 2, 1));
		edges.add(new Edge(1, 3, 2));
		edges.add(new Edge(2, 3, 4));
		edges.add(new Edge(3, 4, 2));
		edges.add(new Edge(4, 5, 6));

		// add all vertex
		for (int i = 0; i < edges.size(); i++) {
			graph.put(edges.get(i).source, new ArrayList<>());
			graph.put(edges.get(i).dest, new ArrayList<>());
		}
		// add all edges
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			graph.get(edge.source).add(edge);
			Edge reverseEdge = new Edge(edge.dest, edge.source, edge.distance);
			graph.get(edge.dest).add(reverseEdge);
		}
		System.out.println("graph=" + graph.toString());

		visitedList.add(edges.get(0).source);
		distanceMap.put(0, 0);
		helper(0);

		// print MST
		for (Edge edge : mst) {

			System.out.println("MST=" + edge);

		}
		// print remaining
		System.out.println("distanceMap=" + distanceMap.toString());
		System.out.println("visited list=" + visitedList.toString());
		System.out.println("min heap=" + minHeap.toString());
	}

	private static void helper(int currentVertex) {

		while (visitedList.size() < graph.size()) {
			// loop all currentVertex neighbours
			List<Edge> neighbors = graph.get(currentVertex);
			for (Edge neighbor : neighbors) {
				if (!visitedList.contains(neighbor.dest)) {
					minHeap.add(neighbor);
				}
			}
			System.out.println("minHeap=" + minHeap.toString());

			Edge edge = minHeap.poll();
			// if dest already visited, get next min distance edge
			while (visitedList.contains(edge.dest)) {
				edge = minHeap.poll();
			}
			// add next destination as current vertex

			visitedList.add(edge.dest);
			mst.add(edge);
			distanceMap.put(edge.dest, distanceMap.get(edge.source) + edge.distance);
			currentVertex = edge.dest;

		}
	}

}
