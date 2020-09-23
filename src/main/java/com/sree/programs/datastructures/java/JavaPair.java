package com.sree.programs.datastructures.java;

import java.util.*;

import javafx.util.Pair;

public class JavaPair {
	public static void main(final String[] args) {
		/**
		 * pair class
		 */
		Pair<Integer, String> pair1 = new Pair<>(1, "sridhar");
		Pair<Integer, String> pair2 = new Pair<>(1, "sridhar");
		Pair<Integer, String> pair3 = new Pair<>(2, "pravali");
		LinkedList<Pair<Integer, String>> list = new LinkedList<>();
		list.add(pair1);
		list.add(pair2);
		list.add(pair3);
		System.out.println("print list=" + list);
		System.out.println("pair1 and pair2 equlas=" + pair1.equals(pair2));
		System.out.println("pair2 and pair3 equlas=" + pair2.equals(pair3));
		System.out.println("pair2 and pair3 equlas=" + pair1.equals(new Pair<>(1, "balaji")));
		System.out.println("pair 1 is there in list=" + list.contains(new Pair<>(1, "sridhar")));

		//
		HashSet<Pair<Integer, String>> set = new HashSet<>();
		set.add(pair1);
		set.add(pair2);
		set.add(pair3);
		System.out.println("print set=" + set);
	}
}
