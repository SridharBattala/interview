package com.sree.programs.algorithms.recursion;

import java.io.*;
import java.util.*;

class FlattenDictionary {
	// driver method
	static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
		HashMap<String, String> output = new HashMap<>();
		flattenDictionaryRec(dict, output, "");
		return output;
	}

	// recursive method
	static void flattenDictionaryRec(HashMap<String, Object> input, HashMap<String, String> output, String tempKey) {

		// recursive case

		for (HashMap.Entry<String, Object> entry : input.entrySet()) {

			if (entry.getValue() instanceof String) {
				output.put(tempKey + entry.getKey(), (String) entry.getValue());
			} else {
				tempKey = tempKey + entry.getKey() + ".";
				flattenDictionaryRec((HashMap<String, Object>) entry.getValue(), output, tempKey);
			}
		}

	}

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("key1", "1");
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("a", "2");
		map1.put("b", "3");
		map.put("key2", map1);

		Map<String, String> output = flattenDictionary(map);
		System.out.println(output);
	}

}
