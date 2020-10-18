package com.sree.programs.algorithms.math;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
	static int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	static String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		// Loop through each symbol, stopping if num becomes 0.
		for (int i = 0; i < values.length && num >= 0; i++) {
			// Repeat while the current symbol still fits into num.
			// in the case of 58, it has to give 3 ones
			while (values[i] <= num) {
				num = num - values[i];
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println("intToRoman 9=" + intToRoman(9));
		// System.out.println("romanToInt 54=" + intToRoman(54));
		System.out.println("romanToInt 54=" + intToRoman(58));

	}
}
