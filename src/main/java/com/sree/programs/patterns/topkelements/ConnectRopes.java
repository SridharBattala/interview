package com.sree.programs.patterns.topkelements;

import java.util.*;

class ConnectRopes {
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

	public static int minimumCostToConnectRopes(int[] ropeLengths) {
		// add all elements to heap
		for (int i = 0; i < ropeLengths.length; i++) {
			minHeap.add(ropeLengths[i]);
		}
		int minCost = 0;
		while (minHeap.size() > 1) {
			int temp = minHeap.poll() + minHeap.poll();
			minCost = minCost + temp;
			minHeap.add(temp);
		}
		return minCost;
	}

	public static void main(String[] args) {
		int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}
}
