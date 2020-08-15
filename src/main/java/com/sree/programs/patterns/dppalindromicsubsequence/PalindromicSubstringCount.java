package com.sree.programs.patterns.dppalindromicsubsequence;

import java.util.*;

public class PalindromicSubstringCount {
	static String input = "cddpd";// "abdbca";
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {

		System.out.println("LCSLength TopDown=" + getCountRecursive(0, input.length() - 1));
		System.out.println(set);
	}

	// pqr
	private static int getCountRecursive(int startIndex, int endIndex) {

		// base case 1
		if (startIndex > endIndex) {
			return 0;
		}

		// recursive case
		else {
			int count1 = 0;

			if (input.charAt(startIndex) == input.charAt(endIndex)) {
				int remainingLength = endIndex - startIndex - 1;
				if (remainingLength == getCountRecursive(startIndex + 1, endIndex - 1)) {
					set.add(input.substring(startIndex, endIndex + 1));
					count1++;
				}

			}
			getCountRecursive(startIndex, endIndex - 1);
			getCountRecursive(startIndex + 1, endIndex);
			return count1;

		}

	}

}
