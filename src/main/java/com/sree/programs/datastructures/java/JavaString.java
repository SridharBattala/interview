package com.sree.programs.datastructures.java;

import java.util.Arrays;

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
		System.out.println("string split=" + "1|2".split("\\|")[0]);
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
		/**
		 * string builder
		 */
		StringBuilder builder = new StringBuilder();
		builder.append("sridhar");
		builder.append(" battala");
		System.out.println("String builder=" + builder.toString());
		/**
		 * string sort
		 */
		String stringSort = "bac";
		Character tempArray[] = new Character[stringSort.length()];
		for (int i = 0; i < stringSort.length(); i++) {
			tempArray[i] = stringSort.charAt(i);
		}

		Arrays.sort(tempArray, (a, b) -> Character.compare(b, a));
		System.out.println("String sort=" + Arrays.toString(tempArray));

		/**
		 * string array sort
		 */
		String[] stringArrSort = { "b", "a", "c" };
		Arrays.sort(stringArrSort, (a, b) -> (a.compareTo(b)));
		System.out.println("string Arr sort=" + Arrays.toString(stringArrSort));

		/**
		 * sub sequences
		 * 
		 */
		String testString = "testString";
		System.out.println("subSequence=" + testString.subSequence(0, 4));

	}
}
