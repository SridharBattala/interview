package com.sree.programs.important.leetcodetop75;

import java.util.*;

class Node {
	public int data;
	public List<Node> neighbors = new ArrayList<Node>();

	public Node(int d) {
		data = d;
	}

	public Node(int data, List<Node> neighbors) {
		this.data = data;
		this.neighbors = neighbors;
	}
}

public class CloneGraph {
	private static HashMap<Node, Node> visited = new HashMap<>();

	public static Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}

		// If the node was already visited before.
		// Return the clone from the visited dictionary.
		if (visited.containsKey(node)) {
			return visited.get(node);
		}

		// Create a clone for the given node.
		// Note that we don't have cloned neighbors as of now, hence [].
		Node cloneNode = new Node(node.data, new ArrayList<>());
		// The key is original node and value being the clone node.
		visited.put(node, cloneNode);

		// Iterate through the neighbors to generate their clones
		// and prepare a list of cloned neighbors to be added to the cloned node.
		for (Node neighbor : node.neighbors) {
			Node clonedNeighbor = cloneGraph(neighbor);
			cloneNode.neighbors.add(clonedNeighbor);
		}
		return cloneNode;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.neighbors = Arrays.asList(node2, node3);
		node2.neighbors = Arrays.asList(node4);
		node3.neighbors = Arrays.asList(node4);
		node4.neighbors = Arrays.asList(node5);

		Node cloneNode = cloneGraph(node1);
		System.out.println("cloneNode data=" + cloneNode.data);
	}
}
