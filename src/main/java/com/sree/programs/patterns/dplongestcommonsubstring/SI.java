package com.sree.programs.patterns.dplongestcommonsubstring;

class SI {
	// driver method
	public boolean findSI(String m, String n, String p) {
		return findSIRecursive(m, n, p, 0, 0, 0);
	}

	// recursive method
	private boolean findSIRecursive(String string1, String string2, String targetString, int string1Index,
			int string2Index, int targetStringIndex) {
		// base case
		if (string1Index == string1.length() && string2Index == string2.length()
				&& targetStringIndex == targetString.length()) {
			return true;
		} else if (targetString.length() == targetStringIndex) {
			return false;
		}

		// recursive case
		else {
			boolean string1Matched = false;
			boolean string2Matched = false;
			if (string1Index < string1.length()
					&& string1.charAt(string1Index) == targetString.charAt(targetStringIndex)) {
				string1Matched = findSIRecursive(string1, string2, targetString, string1Index + 1, string2Index,
						targetStringIndex + 1);
			}

			if (string2Index < string2.length()
					&& string2.charAt(string2Index) == targetString.charAt(targetStringIndex)) {
				string2Matched = findSIRecursive(string1, string2, targetString, string1Index, string2Index + 1,
						targetStringIndex + 1);
			}

			return string1Matched || string2Matched;
		}

	}

	public static void main(String[] args) {
		SI si = new SI();
		System.out.println(si.findSI("abd", "cef", "abcdef"));
		System.out.println(si.findSI("abd", "cef", "adcbef"));
		System.out.println(si.findSI("abc", "def", "abdccf"));
		System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
	}
}
