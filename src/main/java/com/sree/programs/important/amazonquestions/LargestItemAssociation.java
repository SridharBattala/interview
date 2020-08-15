package com.sree.programs.important.amazonquestions;

import java.util.*;
import javafx.util.*;

public class LargestItemAssociation {
	public static void main(final String[] args) {
		final Pair<String, String> p1 = new Pair<String, String>("Item1", "Item2");
		final Pair<String, String> p2 = new Pair<String, String>("Item3", "Item4");
		final Pair<String, String> p3 = new Pair<String, String>("Item4", "Item5");
		final List<Pair<String, String>> list = Arrays.asList(p1, p2, p3);

		final Pair<String, String> p21 = new Pair<String, String>("item3", "item4");
		final Pair<String, String> p22 = new Pair<String, String>("item1", "item2");
		final Pair<String, String> p23 = new Pair<String, String>("item5", "item6");
		final Pair<String, String> p24 = new Pair<String, String>("item4", "item5");
		final Pair<String, String> p25 = new Pair<String, String>("item2", "item7");
		final Pair<String, String> p26 = new Pair<String, String>("item7", "item8");
		final Pair<String, String> p27 = new Pair<String, String>("item2", "item3");
		final Pair<String, String> p28 = new Pair<String, String>("item6", "item7");
		final Pair<String, String> p29 = new Pair<String, String>("item0", "item2");
		final List<Pair<String, String>> list2 = Arrays.asList(p21, p22, p23, p24, p25, p26, p27, p28, p29);

		System.out.println(largestItemAssociation(list));
		System.out.println(largestItemAssociation(list2));
	}

	private static char[] largestItemAssociation(List<Pair<String, String>> input) {
		Collections.sort(input, (a, b) -> a.getKey().compareTo(a.getKey()));
		System.out.println(input);
		return null;
	}
}
