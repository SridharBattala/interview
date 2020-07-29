package com.sree.programs.algorithms.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthPermutation {
	static List<Integer> list = new LinkedList<>();

	public static void main(String args[]) {
		StringBuilder stringBuilder = new StringBuilder();
		int n = 4;
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		findPermutation(n, 8, stringBuilder);

	}

	// define block size, for n=4 block size=(n-1)!=6
	// check which segment ur output is there, (k-1)/block size=1, means second
	// segment
	// we need to decrease k, k=k-(selected segment*block size) = 8-(1*6)=2
	private static void findPermutation(int n, int k, StringBuilder stringBuilder) {
		if (list.isEmpty()) {
			System.out.println(stringBuilder.toString());
			return;
		}
		int blockSize = factorial(n - 1);
		int segment = (k - 1) / blockSize;
		stringBuilder.append(list.get(segment));
		list.remove(segment);
		k = k - (segment * blockSize);
		findPermutation(n - 1, k, stringBuilder);
	}

	static int factorial(int n) {
		// base case
		if (n == 0 || n == 1) {
			return 1;
		}
		// recursive case
		else {
			return n * factorial(n - 1);
		}

	}
}
