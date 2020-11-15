package com.sree.programs.important.askedininterviews;

import java.util.*;

public class AmazonShipmentShortestDistance {
	static class Distance {
		String start;
		String end;
		int distanace;

		public Distance(String start, String end, int distanace) {
			super();
			this.start = start;
			this.end = end;
			this.distanace = distanace;
		}

	}

	public static List<Distance> distances = new ArrayList<>();
	public static Map<String, Integer> distanceMap = new HashMap<>();
	static {
		distances.add(new Distance("seattle", "newyork", 1));
		distances.add(new Distance("seattle", "ca", 2));
		distances.add(new Distance("seattle", "texas", 3));
		distances.add(new Distance("newyork", "ca", 4));
		distances.add(new Distance("newyork", "texas", 5));
		distances.add(new Distance("ca", "texas", 6));

		for (Distance distance : distances) {
			distanceMap.put(distance.start + "|" + distance.end, distance.distanace);
		}
	}

	public static void main(String[] args) {
		List<String> destinations = new ArrayList<>();
		destinations.add("newyork");
		destinations.add("ca");
		destinations.add("texas");
		String startCity = "seattle";
		Map<String, String> shortestPathMap = new LinkedHashMap<>();
		List<String> visitedList = new LinkedList<>();
		getShortestDistancePaths(destinations, startCity, shortestPathMap, visitedList);
		System.out.println(shortestPathMap.toString());
	}

	private static void getShortestDistancePaths(List<String> destinations, String startCity,
			Map<String, String> callStack, List<String> visitedList) {
		if (visitedList.size() + 1 == destinations.size()) {
			return;
		}

		int minDistance = Integer.MAX_VALUE;
		visitedList.add(startCity);
		String newStart = null;
		for (String destination : destinations) {
			if (!visitedList.contains(destination)) {
				int currentDistance = getDistance(startCity, destination);
				if (minDistance > currentDistance) {
					minDistance = currentDistance;
					newStart = destination;
				}
			}

		}
		callStack.put(startCity, newStart);
		getShortestDistancePaths(destinations, newStart, callStack, visitedList);
	}

	private static int getDistance(String startCity, String destination) {
		if (distanceMap.containsKey(startCity + "|" + destination)) {
			return distanceMap.get(startCity + "|" + destination);
		} else {
			return 1;
		}

	}

}
