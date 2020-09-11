package com.sree.programs.important.askedininterviews;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class RobloxCoursePairs {
	public static void main(String[] argv) {
		String[][] studentCoursePairs1 = { { "58", "Linear Algebra" }, { "94", "Art History" },
				{ "94", "Operating Systems" }, { "17", "Software Design" }, { "58", "Mechanics" },
				{ "58", "Economics" }, { "17", "Linear Algebra" }, { "17", "Political Science" }, { "94", "Economics" },
				{ "25", "Economics" }, { "58", "Software Design" }

		};

		String[][] studentCoursePairs2 = { { "42", "Software Design" }, { "0", "Advanced Mechanics" },
				{ "9", "Art History" }, };
		Map<String, List<String>> output = getCoursePairs(studentCoursePairs1);
		System.out.println(output.toString());
	}
	/*
	 * 1,2 --> a 1,3--> [] 2,3 -->[]
	 * 
	 * 1->a 2-->a,b 3 -->c
	 * 
	 * 1,2 2,3 3,1
	 */

	public static Map<String, List<String>> getCoursePairs(String[][] coursePairs) {
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < coursePairs.length; i++) {
			if (map.containsKey(Integer.valueOf(coursePairs[i][0]))) {
				map.get(Integer.valueOf(coursePairs[i][0])).add(coursePairs[i][1]);
			} else {
				List<String> list = new LinkedList<>();
				list.add(coursePairs[i][1]);
				map.put(Integer.valueOf(coursePairs[i][0]), list);

			}

		}
		System.out.println("map=" + map.toString());
		// create combinations
		Object[] keySet = map.keySet().toArray();
		Map<String, List<String>> output = new HashMap<>();
		for (int i = 0; i < keySet.length; i++) {
			for (int j = i + 1; j < keySet.length; j++) {
				List<String> courses1 = map.get(keySet[i]);
				List<String> courses2 = map.get(keySet[j]);
				String string = String.valueOf(keySet[i]) + "," + String.valueOf(keySet[j]);
				// System.out.println("courses1=" + courses1.toString());
				// System.out.println("courses2=" + courses2.toString());
				if (courses1 != null && courses2 != null && !courses1.isEmpty() && !courses2.isEmpty()) {

					List<String> courses = courses1.stream().filter(value -> courses2.contains(value))
							.collect(Collectors.toList());
					// System.out.println("courses1=" + courses1.toString());
					output.put(string, courses);
				} else {
					output.put(string, new LinkedList<>());
				}

			}
		}
		return output;

	}

}