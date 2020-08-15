package com.sree.programs.datastructures.java;

public class JavaString {
	public static void main(String[] args) {
		/**
		 * string methods
		 */
		String string = "sridhar";
		string.length();
		string.charAt(1);
		string.indexOf('r');
		// beginIndex , inclusive.
		// endIndex , exclusive.
		String subString = string.substring(1, 3);
		System.out.println("subString=" + subString);
	}
}
