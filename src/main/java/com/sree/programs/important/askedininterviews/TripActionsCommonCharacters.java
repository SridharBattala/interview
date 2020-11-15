package com.sree.programs.important.askedininterviews;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.*;

public class TripActionsCommonCharacters {
	public static void main(String args[]) {
		List<String> strings = Arrays.asList("bella", "label", "roller");
		getCommonCharacters(strings);
	}

	private static void getCommonCharacters(List<String> strings) {
		Map<Character, Integer> resultMap = new HashMap<>();
		Map<Character, Integer> currentCountMap = new HashMap<>();
		for (int index = 0; index < strings.get(0).length(); index++) {
			char currentChar = strings.get(0).charAt(index);
			resultMap.put(currentChar, resultMap.getOrDefault(currentChar, 0) + 1);
		}

		for (int i = 1; i < strings.size(); i++) {
			// get character count
			currentCountMap.clear();
			String currentString = strings.get(i);
			for (int index = 0; index < currentString.length(); index++) {
				char currentChar = currentString.charAt(index);
				currentCountMap.put(currentChar, currentCountMap.getOrDefault(currentChar, 0) + 1);
			}
			System.out.println("resultMap=" + resultMap.toString());
			System.out.println("currentCountMap=" + currentCountMap.toString());
			for (Entry<Character, Integer> entry : resultMap.entrySet()) {
				if (!currentCountMap.containsKey(entry.getKey())
						|| currentCountMap.get(entry.getKey()) != entry.getValue()) {
					resultMap.put(entry.getKey(), 0);
				}
			}
		}
		System.out.println("resultMap=" + resultMap.toString());
	}
}
