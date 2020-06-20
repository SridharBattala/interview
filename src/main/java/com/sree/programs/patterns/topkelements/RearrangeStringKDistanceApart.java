package com.sree.programs.patterns.topkelements;

import java.util.*;

public class RearrangeStringKDistanceApart {
	public static String reorganizeString(String input, int k) {
		// freq map
		Map<Character, Integer> freqMap = new HashMap<>();
		for (int index = 0; index < input.length(); index++) {
			freqMap.put(input.charAt(index), freqMap.getOrDefault(input.charAt(index), 0) + 1);
		}
		// create maxHeap
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue());
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			maxHeap.add(entry);
		}
		// loop heap
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuilder output = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
			currentEntry.setValue(currentEntry.getValue() - 1);
			output.append(currentEntry.getKey());
			queue.offer(currentEntry);
			if (queue.size() == k && queue.peek().getValue() > 0) {
				maxHeap.add(queue.poll());
			}
		}
		if (output.toString().length() == input.length()) {
			return output.toString();
		} else {
			return "";
		}

	}

	public static void main(String[] args) {
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aab", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
	}
}
