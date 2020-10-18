package com.sree.programs.important.amazonquestions;

import java.util.*;

public class LargestNumber {
	public static void main(String[] args) {

		System.out.println("largest Number=" + largestNumber(Arrays.asList(1, 2, 0, 3)));
	}

	public static String largestNumber(final List<Integer> input) {

		String[] arr = new String[input.size()];
		for (int i = 0; i < input.size(); i++) {
			arr[i] = String.valueOf(input.get(i));
		}

		Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}

		if (sb.charAt(0) == '0') { // check if all zeroes are there
			return String.valueOf(0);
		}

		return sb.toString();
	}
}
