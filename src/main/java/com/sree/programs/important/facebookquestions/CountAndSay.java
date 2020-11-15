package com.sree.programs.important.facebookquestions;

import java.util.*;

public class CountAndSay {
	public static void main(String[] args) {

		System.out.println("countAndSay=" + countAndSay(4));
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String ans = "1";
		for (int i = 2; i <= n; i++) {
			ans = getCountString(ans);
			System.out.println("countAndSay for " + i + "=" + ans);
		}
		return ans;
	}

	static String getCountString(String string) {
		// build hash map of each character count, then convert hashmap to string
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int index = 0; index < string.length(); index++) {
			map.put(string.charAt(index), map.getOrDefault(string.charAt(index), 0) + 1);
		}
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			builder.append(entry.getValue() + "" + entry.getKey());
		}
		return builder.toString();
	}
}
