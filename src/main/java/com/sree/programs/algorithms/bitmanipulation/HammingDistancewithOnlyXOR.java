package com.sree.programs.algorithms.bitmanipulation;

public class HammingDistancewithOnlyXOR {

	public static int getDistance(int x, int y) {

		// first get the XOR of x and y
		int xor = x ^ y;

		// now count all set bits in it
		int bitCount = 0;
		while (xor > 0) {
			// dividing by 2 and checking for remainder==1
			if (xor % 2 == 1) {
				bitCount++;
			}
			// dividing by 2
			xor = xor / 2;
		}
		return bitCount;
	}

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		System.out.println("x=" + x + ", y=" + y + "  Hamming distance: " + getDistance(x, y));

	}
}
