package com.sree.programs.important.leetcodetop75;

public class MostWaterContainer {
	public static void main(String[] args) {
		int[] input1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] input2 = { 3, 1, 2, 4, 5 };
		System.out.println("max area=" + maxArea(input1));
		System.out.println("max area=" + maxArea(input2));
	}

	public static int maxArea(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}

		}
		return maxarea;
	}
}
