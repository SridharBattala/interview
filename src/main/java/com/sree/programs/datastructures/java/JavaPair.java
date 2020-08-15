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
		System.out.println("pair1 and pair2 equlas=" + pair1.equals(pair2));
		System.out.println("pair2 and pair3 equlas=" + pair2.equals(pair3));
	}
}
