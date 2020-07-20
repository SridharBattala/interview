package com.sree.programs.patterns.dplongestcommonsubstring;

public class StringInterleaving {
	public static void main(String[] args) {

		System.out.println(findSI("abd", "cef", "abcdef"));
		System.out.println(findSI("abd", "cef", "adcbef"));
		System.out.println(findSI("abc", "def", "abdccf"));
		System.out.println(findSI("abcdef", "mnop", "mnaobcdepf"));
	}

	private static boolean findSI(String string1, String string2, String targetString) {
		return findSIRecursive(string1, string2, targetString, 0, 0, 0);
	}

	private static boolean findSIRecursive(String string1, String string2, String targetString, int index1, int index2,
			int targetIndex) {
		if (index1 == string1.length() && index2 == string2.length() && targetIndex == targetString.length()) {
			return true;
		} else if (targetIndex == targetString.length()) {
			return false;
		} else {
			boolean string1matching = false;
			boolean string2matching = false;
			if (index1 < string1.length() && string1.charAt(index1) == targetString.charAt(targetIndex)) {
				string1matching = findSIRecursive(string1, string2, targetString, index1 + 1, index2, targetIndex + 1);
			}
			if (index2 < string2.length() && string2.charAt(index2) == targetString.charAt(targetIndex)) {
				string1matching = findSIRecursive(string1, string2, targetString, index1, index2 + 1, targetIndex + 1);

			}
			return string1matching || string2matching;
		}
	}
}
