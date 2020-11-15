package com.sree.programs.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TravellingSalesMan {
	static class Distance {
		int startCity;
		int endCity;
		int distance;

		public Distance(int startCity, int endCity, int distance) {
			super();
			this.startCity = startCity;
			this.endCity = endCity;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "[" + startCity + "," + endCity + "," + distance + "]";
		}
	}

	static int citiesCount = 4;
	static int[][] distanceGraph = { { 0, 20, 42, 25 }, { 20, 0, 300, 34 }, { 42, 300, 0, 10 }, { 25, 34, 10, 0 } };
	static LinkedList<Integer> visited = new LinkedList<>();
	static int minDistance = Integer.MAX_VALUE;
	static LinkedList<Distance> path = new LinkedList<>();

	public static void main(String[] args) {
		visited.add(0);
		LinkedList<Distance> callStack = new LinkedList<>();
		minDistance(0, callStack, 0);
		System.out.println("min distance=" + minDistance);
		System.out.println("path=" + path.toString());
	}

	private static void minDistance(int startCity, LinkedList<Distance> callStack, int currentDisatnce) {
		if (visited.size() == citiesCount) {
			if (minDistance > currentDisatnce) {
				minDistance = currentDisatnce;
				path = new LinkedList<>(callStack);
			}
			return;
		}

		for (int endCity = 0; endCity < citiesCount; endCity++) {

			if (!visited.contains(endCity)) {
				visited.add(endCity);
				callStack.add(new Distance(startCity, endCity, distanceGraph[startCity][endCity]));
				currentDisatnce = currentDisatnce + distanceGraph[startCity][endCity];

				minDistance(endCity, callStack, currentDisatnce);
				currentDisatnce = currentDisatnce - distanceGraph[startCity][endCity];
				visited.removeLast();
				callStack.removeLast();

			}

		}

	}

}
