package com.sree.programs.patterns.topkelements;

import java.util.*;
import java.lang.Math;;

public class KClosestPointsToOrigin {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public double distanceFromOrigin() {
			return Math.sqrt(this.x * this.x + this.y * this.y);
		}
	}

	static PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(
			(a, b) -> Double.compare(b.distanceFromOrigin(), a.distanceFromOrigin()));

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 1), new Point(1, 3), new Point(3, 4), new Point(2, -1) };
		List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
		System.out.print("Here are the k points closest the origin: ");
		for (Point p : result)
			System.out.print("[" + p.x + " , " + p.y + "] ");
	}

	private static List<Point> findClosestPoints(Point[] points, int k) {
		for (int i = 0; i < k; i++) {
			maxHeap.add(points[i]);
		}
		for (int i = k; i < points.length; i++) {
			if (maxHeap.peek().distanceFromOrigin() > points[i].distanceFromOrigin()) {
				maxHeap.poll();
				maxHeap.add(points[i]);
			}
		}
		// loop heap
		List<Point> output = new LinkedList<>();
		for (Point point : maxHeap) {
			output.add(point);
		}
		return output;
	}

}
