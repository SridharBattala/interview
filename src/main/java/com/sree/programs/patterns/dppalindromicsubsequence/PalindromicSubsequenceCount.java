package com.sree.programs.patterns.dppalindromicsubsequence;

import java.util.*;

public class PalindromicSubsequenceCount {

	public static void main(String[] args) {
		String string = "bccb";
		System.out.println("LCSLength TopDown=" + findLPSLength(string, 0, string.length() - 1));

	}

	private static int findLPSLength(String string, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		} else if (startIndex == endIndex) {
			return 1;
		} else {

			int count = 0;
			if (string.charAt(startIndex) == string.charAt(endIndex)) {
				count = 1 + findLPSLength(string, startIndex + 1, endIndex - 1);
			} else {
				count = findLPSLength(string, startIndex + 1, endIndex)
						+ findLPSLength(string, startIndex, endIndex - 1)
						- findLPSLength(string, startIndex + 1, endIndex - 1);
			}

			return count;
		}
	}

}
