package com.sree.programs.important.leetcode;

import java.util.*;

public class MegeInteval_MinArrowShotsBallons {
	public static void main(String[] args) {
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		System.out.println("findMinArrowShots=" + findMinArrowShots(points));
	}

	public static int findMinArrowShots(int[][] points) {

		if (points.length == 0)
			return 0;
		Arrays.sort(points, (a, b) -> a[0] - b[0]);
		for (int[] arr : points) {
			System.out.println("  after sort=" + Arrays.toString(arr));
		}

		int arrow = 0; // if more than 0 balloons then atleast 1 arrow to start
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			int currentStart = points[i][0];
			if (end > currentStart) {
				arrow++;
				end = Math.min(end, points[i][1]);

			} else {
				end = points[i][1];
			}
		}
		return arrow;
	}
}
