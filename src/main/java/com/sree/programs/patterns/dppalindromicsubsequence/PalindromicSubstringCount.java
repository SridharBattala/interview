package com.sree.programs.patterns.dppalindromicsubsequence;

import java.util.*;

public class PalindromicSubstringCount {
	static String input = "madam";// "abdbca";

	public static void main(String[] args) {

		System.out.println("LCSLength TopDown=" + findLPSLengthTopDown(0, input.length() - 1));

	}

	private static int findLPSLengthTopDown(int startIndex, int endIndex) {

		// base case 1
		if (startIndex > endIndex) {
			return 0;
		}
		// base case 2
		else if (startIndex == endIndex) {
			return 1;
		}
		// recursive case
		else {
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			if (input.charAt(startIndex) == input.charAt(endIndex)) {
				int remainingLength = endIndex - startIndex - 1;
				if (endIndex - startIndex == 1
						|| remainingLength == findLPSLengthTopDown(startIndex + 1, endIndex - 1)) {
					return count1 + 1;
				}

			}
			findLPSLengthTopDown(startIndex, endIndex - 1);
			findLPSLengthTopDown(startIndex + 1, endIndex);

			return 0;
		}

	}

}
