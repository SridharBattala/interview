package com.sree.programs.datastructures.strings;

public class StrStr {
	public static void main(String[] args) {
		String string1 = "leetcode";
		String string2 = "ee";
		strStr(string1, string2);
	}

	public static int strStr(String string1, String string2) {
		int string1length = string1.length();
		int string2length = string2.length();

		for (int start = 0; start < string1length - string2length + 1; start++) {
			if (string1.substring(start, start + string2length).equals(string2)) {
				return start;
			}
		}
		return -1;
	}
}
