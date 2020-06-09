package com.sree.programs.algorithms.math;

public class SquareRoot {
	private static final double EPSILON = 0.000000000000001;

	public static void main(String[] args) {
		double[] arr = { 16, 17, 2.25 };
		for (double i : arr)
			System.out.println("Square root of " + i + " is " + squareRoot(i));
	}

	private static double squareRoot(double num) {
		double low = 0;
		double high = 1 + (num / 2);

		while (low < high) {
			double mid = (low + high) / 2;
			double square = mid * mid;
			double diff = Math.abs(num - square);
			if (diff <= EPSILON) {
				return mid;
			}
			if (square > num) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return -1;
	}
}
