package com.sree.programs.datastructures.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaHashSet {
	public static void main(String[] args) {
		/**
		 * Hash map
		 */
		Set<String> set = new HashSet<>();
		set.add("sridhar");
		set.add("pravali");
		/**
		 * looping
		 */
		for (String string : set) {
			System.out.println(string);
		}
		/**
		 * methods
		 */
		set.clear();// remove all the mappings
		set.size();
		set.isEmpty();
		set.remove("pravali");
		// duplicate arrays
		Set<List<Integer>> arraySet = new HashSet<>();
		arraySet.add(Arrays.asList(1, 2, 3));
		arraySet.add(Arrays.asList(1, 2, 3));
		arraySet.add(Arrays.asList(1, 2, 3, 4));
		System.out.println("arraySet=" + arraySet);
	}
}
