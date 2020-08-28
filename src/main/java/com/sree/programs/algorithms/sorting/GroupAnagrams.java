package com.sree.programs.algorithms.sorting;

import java.util.*;

class GroupAnagrams {
	public static String groupAnagrams(String arr[]) {
		HashMap<String, List<String>> myMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) // traverse all the words
		{
			String word = arr[i];
			char[] letters = word.toCharArray(); // convert the given String Array's each index value to char array
			Arrays.sort(letters); // now sort all the words (based of letter's ASCII values using built in sort
									// function for Arrays)
			String newWord = new String(letters); // and then re-convert each word to separate String

			if (myMap.containsKey(newWord)) {// calculate hash code of string after sorting
				myMap.get(newWord).add(word);
			} else {
				List<String> totalWords = new ArrayList<>();
				totalWords.add(word); // Add words for the specific hash code
				myMap.put(newWord, totalWords);
			}
		}
		String x = "";
		for (String s : myMap.keySet()) // print values if size is > 1, If you want to print non-anagrams, then print
										// the values with size = 1
		{
			List<String> values = myMap.get(s);
			if (values.size() > 1)
				x = x + values;
		}
		return x;
	}

	public static void main(String[] args) {
		String arr[] = { "cat", "dog", "tac", "god", "act", "tom marvolo riddle ", "abc", "def", "cab", "fed",
				"clint eastwood ", "i am lord voldemort", "elvis", "old west action", "lives" };
		System.out.println(groupAnagrams(arr));
	}
}