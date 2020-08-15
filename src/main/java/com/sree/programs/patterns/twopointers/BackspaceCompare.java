package com.sree.programs.patterns.twopointers;

//package whatever; // don't place package name!

import java.io.*;

class BackspaceCompare {
	public static void main(String[] args) {
		System.out.println("matched=" + compare("xy#z", "xzz#"));

	}

	public static boolean compare(String str1, String str2) {
		int str1Index = str1.length() - 1, str2Index = str2.length() - 1;

		while (str1Index >= 0 && str2Index >= 0) {
			if (str1.charAt(str1Index) == '#') {
				str1Index = str1Index - 2;
			}
			if (str2.charAt(str2Index) == '#') {
				str2Index = str2Index - 2;
			}
			System.out.println("str1 char=" + str1.charAt(str1Index));
			System.out.println("str2 char=" + str2.charAt(str2Index));
			if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
				return false;

			}
			str1Index--;
			str2Index--;
		}
		if (str1Index == -1 && str2Index == -1) {
			return true;
		} else {
			return false;
		}

	}
}
