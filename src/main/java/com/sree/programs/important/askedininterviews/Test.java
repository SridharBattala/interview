package com.sree.programs.important.askedininterviews;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		String s = "aabbb";
		System.out.println("output=" + solve(s));
	}

	public static boolean solve(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains('b') && s.charAt(i) == 'a') {
				return false;
			} else {
				set.add(s.charAt(i));
			}

		}
		return true;
	}
}
