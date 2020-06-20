package com.sree.programs.important.askedininterviews;

/*
 * https://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
import java.util.*;

class SortPreference {
	public SortPreference(int frequency, int recency) {
		super();
		this.frequency = frequency;
		this.recency = recency;
	}

	public int frequency;
	public int recency;
}

public class GoogleQuestion {

	// Given a list of strings, return a list of strings ordered by first
	// occurrences (primary) and then recency (secondary).

	// Example
	// input: b, a, c, a, b, b, a, c
	// output: a -> b -> c
	// a occurred 3 times,
	// b occurred 3 times,
	// c occurred 2 times.
	// a and b has higher occurrences than c, so they are ordered before c.
	// a has higher recency than b, so a is ordered before b.
	public static void main(String args[]) {
		char[] input = { 'b', 'a', 'c', 'a', 'b', 'a', 'b', 'c' };
		System.out.println("output=" + sort(input));
	}

	private static List<Character> sort(char[] input) {
		// create hash map
		Map<Character, SortPreference> map = new HashMap<>();
		for (int index = 0; index < input.length; index++) {
			char ch = input[index];
			SortPreference sortPreference = null;
			if (map.containsKey(ch)) {
				sortPreference = map.get(input[index]);
				sortPreference.frequency = sortPreference.frequency + 1;
				sortPreference.recency = index;
			} else {
				sortPreference = new SortPreference(1, index);

			}
			map.put(input[index], sortPreference);
		}

		// create max heap
		PriorityQueue<Map.Entry<Character, SortPreference>> maxHeap = new PriorityQueue<>((a, b) -> {
			if (b.getValue().frequency == a.getValue().frequency) {
				return b.getValue().recency - a.getValue().recency;
			} else {
				return b.getValue().frequency - a.getValue().frequency;
			}
		});
		// add map to max heap
		for (Map.Entry<Character, SortPreference> entry : map.entrySet()) {
			maxHeap.add(entry);
		}

		// loop max heap and add values to output
		List<Character> output = new LinkedList<>();
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, SortPreference> entry = maxHeap.poll();
			output.add(entry.getKey());
		}
		return output;
	}

}
