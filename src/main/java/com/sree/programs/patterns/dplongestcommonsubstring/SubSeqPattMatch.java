package com.sree.programs.patterns.dplongestcommonsubstring;

//package whatever; // don't place package name!

import java.io.*;

class SubSeqPattMatch {

	public static void main(String[] args) {
		String string = "tomorrow";
		String pattern = "tor";
		System.out.println("PattMatchCount=" + getPattMatchCount(string, pattern));
	}

	/*
	 * sub sequence
	 */
	public static int getPattMatchCount(String string, String pattern) {
		return getPattMatchCountRecursive(string, pattern, 0, 0);
	}

	public static int getPattMatchCountRecursive(String string, String pattern, int stringIndex, int patternIndex) {
		if (patternIndex == pattern.length()) {
			return 1;
		} else if (stringIndex == string.length()) {
			return 0;
		} else {
			int count1 = 0;
			if (string.charAt(stringIndex) == pattern.charAt(patternIndex)) {
				count1 = getPattMatchCountRecursive(string, pattern, stringIndex + 1, patternIndex + 1);
			}
			int count2 = getPattMatchCountRecursive(string, pattern, stringIndex + 1, patternIndex);

			return count1 + count2;
		}
	}

}
