package com.sree.programs.algorithms.math;

/*
 * https://www.geeksforgeeks.org/find-two-rectangles-overlap/

 */
public class OverlappingRectangles {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	// random in position
	// random in size
	static boolean checkForoverlapping(Point rect1TopLeft, Point rect1BottomRight, Point rect2TopLeft,
			Point rect2BottomRight) {

		// If one rectangle is on left side of other
		if (rect1TopLeft.x >= rect2BottomRight.x || rect2TopLeft.x >= rect1BottomRight.x) {
			return false;
		}

		// If one rectangle is above other
		if (rect1BottomRight.y >= rect2TopLeft.y || rect2BottomRight.y >= rect1TopLeft.y) {
			return false;
		}

		return true;
	}

	// Driver Code
	public static void main(String[] args) {
		Point rect1TopLeft = new Point(0, 10), rect1BottomRight = new Point(10, 0);
		Point rect2TopLeft = new Point(5, 5), rect2BottomRight = new Point(15, 0);

		// Function Call
		System.out.println(
				"overlaped=" + checkForoverlapping(rect1TopLeft, rect1BottomRight, rect2TopLeft, rect2BottomRight));
	}
}
