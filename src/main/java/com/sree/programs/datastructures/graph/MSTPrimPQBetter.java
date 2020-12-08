package com.sree.programs.datastructures.graph;

/**
 * https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
 * 
 * Prim’s – Minimum Spanning Tree (MST) |using Adjacency List and Priority Queue
 * without decrease key in O(ElogV)
 * 
 * @author sbattala
 *
 */
import javafx.util.Pair;

import java.util.*;

import com.sree.programs.datastructures.graph.MinimumSpanningTreePrims.Edge;

public class MSTPrimPQBetter {
	static int minDistance = 0;
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
			graph.get(edges.get(i).source).add(edges.get(i));
			graph.get(edges.get(i).dest).add(edges.get(i));
		}
		System.out.println("graph=" + graph.toString());

		visitedList.add(edges.get(0).source);

		helper(0);
		System.out.println("minDistance=" + minDistance);
		// print MST
		for (Edge edge : mst) {

			System.out.println("MST=" + edge);

		}
		// print remaining
		System.out.println("visited list=" + visitedList.toString());
		System.out.println("min heap=" + minHeap.toString());
	}

	private static void helper(int currentVertex) {

		while (visitedList.size() < graph.size()) {
			// loop all currentVertex neighbours
			List<Edge> neighbors = graph.get(currentVertex);
			for (Edge neighbor : neighbors) {
				// bidirectional graph
				if ((neighbor.source == currentVertex && !visitedList.contains(neighbor.dest))
						|| (neighbor.dest == currentVertex && !visitedList.contains(neighbor.source))) {
					// HeapEdge heapEdge=new HeapEdge(neighbor.dest,neighbor.distance);
					minHeap.add(neighbor);
				}
			}
			System.out.println("minHeap=" + minHeap.toString());

			Edge edge = minHeap.poll();
			// if both vertices of edge already visited, get next min distance edge
			while (visitedList.contains(edge.source) && visitedList.contains(edge.dest)) {
				edge = minHeap.poll();
			}
			// if currentVertex is source, pick dest as current vertex
			if (edge.source == currentVertex) {
				if (!visitedList.contains(edge.dest)) {
					visitedList.add(edge.dest);
					mst.add(edge);
					minDistance = minDistance + edge.distance;
					currentVertex = edge.dest;

				}
			}
			// if currentVertex is dest, pick source as current vertex
			else {
				if (!visitedList.contains(edge.source)) {
					visitedList.add(edge.source);
					mst.add(edge);
					minDistance = minDistance + edge.distance;
					currentVertex = edge.source;

				}
			}

		}
	}
}
