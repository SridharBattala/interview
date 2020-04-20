package com.sree.programs.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphClone {
	private static class Node {
		public int data;

		@Override
		public String toString() {
			return ""+ data;
		}

		public List<Node> neighbors = new ArrayList<Node>();

		public Node(int d) {
			data = d;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.neighbors.addAll(Arrays.asList(node2, node4, node5));
		node2.neighbors.addAll(Arrays.asList(node1, node3));
		node4.neighbors.addAll(Arrays.asList(node3, node5));
		cloneGraph(node1);
	}

	private static void cloneGraph(Node node1) {
		Set<Integer> visited = new HashSet<>();
		printHelper(node1, visited);
		System.out.println();
		visited.clear();
		Map<Integer,Node> visistedMap=new HashMap<>();
		Node newNode = helper(node1, visistedMap,new HashSet<>() );
		visited = new HashSet<>();
		printHelper(newNode, visited);

	}

	private static void printHelper(Node current, Set<Integer> visited) {

		System.out.println(current.toString() + "-->" + current.neighbors.toString());
		// add to visited list
		visited.add(current.data);
		// loop childrens
		for (Node neighbor : current.neighbors) {

			// if neigbour is not visisted then call helper
			if (!visited.contains(neighbor.data)) {
				printHelper(neighbor, visited);
			}
		}

	}

	private static Node helper(Node current, Map<Integer,Node> visited,Set<Integer> visitedSet) {
		//System.out.println("current="+current+", current neighbors="+current.neighbors+", visited="+visited);
		visitedSet.add(current.data);
		// create new node for current
		Node currentNew = null;
		if (visited.containsKey(current.data)) {
			currentNew=visited.get(current.data);
		}else {
			currentNew = new  Node(current.data);
			visited.put(currentNew.data,currentNew);

		}
		
		// loop childrens
		for (Node neighbor : current.neighbors) {
			// add current neighbors as new node neighbors
			Node neighborNew = null;
			if (visited.containsKey(neighbor.data)) {
				neighborNew=visited.get(neighbor.data);
			}else {
				neighborNew = new Node(neighbor.data);
			}
			visited.put(neighborNew.data,neighborNew);
			currentNew.neighbors.add(neighborNew);

			// if neigbour is not visisted then call helper
			if (!visitedSet.contains(neighbor.data)) {
				helper(neighbor, visited,visitedSet);
			}
		}
		//System.out.println("currentNew="+currentNew+", currentNew neighbors="+currentNew.neighbors+", visited="+visited);

		return currentNew;
	}

}
