package com.sree.programs.algorithms.math;

import com.sree.programs.algorithms.math.OverlappingRectangles.Point;

/*
 * https://www.geeksforgeeks.org/total-area-two-overlapping-rectangles/

 */
public class OverlappingRectanglesArea {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	// Returns Total Area of two overlap
	// rectangles
	static int overlappingArea(Point rect1TopRight, Point rect1BottomLeft, Point rect2TopRight, Point rect2BottomLeft) {

		// Length of intersecting part i.e
		// start from max(l1.x, l2.x) of
		// x-coordinate and end at min(r1.x,
		// r2.x) x-coordinate by subtracting
		// start from end we get required
		// lengths
		int areaI = (Math.min(rect1TopRight.x, rect2TopRight.x) - Math.max(rect1BottomLeft.x, rect2BottomLeft.x))
				* (Math.min(rect1TopRight.y, rect2TopRight.y) - Math.max(rect1BottomLeft.y, rect2BottomLeft.y));

		return areaI;
	}

	// Driver Code
	public static void main(String[] args) {
		Point rect1TopRight = new Point(5, 5), rect1BottomLeft = new Point(2, 1);
		Point rect2TopRight = new Point(5, 7), rect2BottomLeft = new Point(3, 2);

		// Function Call
		System.out.println(
				"overlappingArea=" + overlappingArea(rect1TopRight, rect1BottomLeft, rect2TopRight, rect2BottomLeft));
	}
}
