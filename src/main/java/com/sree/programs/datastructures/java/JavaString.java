package com.sree.programs.datastructures.java;

public class JavaString {
	public static void main(String[] args) {
		/**
		 * string methods
		 */
		String string = "sridhar.battala";
		string.length();
		string.charAt(1);
		string.contains("s");
		string.indexOf('r');// first occurance
		string.lastIndexOf('r');// last occurance
		System.out.println("split=" + string.split("\\.")[1]);
		// beginIndex , inclusive.
		// endIndex , exclusive.
		String subString = string.substring(1, 3);
		System.out.println("subString=" + subString);
		/**
		 * string to int
		 */
		String numStr = "123";
		int num = Integer.valueOf(numStr).intValue();
		/**
		 * String to array
		 */
		char[] charArr = string.toCharArray();
		/**
		 * array to string
		 */
		String string1 = new String(charArr);

	}
}
