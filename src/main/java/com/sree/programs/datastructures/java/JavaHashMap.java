package com.sree.programs.datastructures.java;

import java.util.HashMap;
import java.util.Map;

public class JavaHashMap {
	public static void main(String[] args) {
		/**
		 * Hash map
		 */
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "sridhar");
		map.put(2, "pravali");
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "sridhar");
		map1.put(2, "pravali");
		/**
		 * looping
		 */
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
		/**
		 * compare map
		 */
		System.out.println("map compare= " + map.equals(map1));
		/**
		 * methods
		 */
		// map.clear();// remove all the mappings
		// map.size();
		// map.isEmpty();
		// map.remove(1);
		// map.remove(1, "sridhar");
		// map.get(2);
		// map.keySet();
		// map.values();
	}
}
