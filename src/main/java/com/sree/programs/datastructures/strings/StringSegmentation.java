package com.sree.programs.datastructures.strings;

import java.util.*;

public class StringSegmentation {
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		String s = new String();
		s = "hellonow";

		dictionary.add("hello");
		dictionary.add("hell");
		dictionary.add("on");
		dictionary.add("now");
		if (canSegmentString(s, dictionary)) {
			System.out.println("String Can be Segmented");
		} else {
			System.out.println("String Can NOT be Segmented");
		}
	}

	private static boolean canSegmentString(String s, Set<String> dictionary) {
		// TODO Auto-generated method stub
		return false;
	}
}
