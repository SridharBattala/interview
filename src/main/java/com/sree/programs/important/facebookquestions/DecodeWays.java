package com.sree.programs.important.facebookquestions;

/**
 * https://leetcode.com/problems/decode-ways/
 */
import java.util.*;

class DecodeWays {

	static HashMap<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("decoding ways=" + numDecodings("226"));
	}

	private static int recursiveWithMemo(String str, int index, LinkedList<String> callStack) {

		// If you reach the end of the string
		// Return 1 for success.
		if (index == str.length()) {
			System.out.println("callStack=" + callStack);
			return 1;
		}

		// If the string starts with a zero, it can't be decoded
		if (str.charAt(index) == '0') {
			return 0;
		}
		if (index == str.length() - 1) {
			callStack.add(Character.toString(str.charAt(index)));
			System.out.println("callStack=" + callStack);
			callStack.removeLast();
			return 1;
		}
		if (index > str.length()) {
			return 0;
		}

		// Memoization is needed since we might encounter the same sub-string.
		if (memo.containsKey(index)) {
			return memo.get(index);
		}
		callStack.add(Character.toString(str.charAt(index)));
		int ans = recursiveWithMemo(str, index + 1, callStack);
		callStack.removeLast();
		if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
			callStack.add(str.substring(index, index + 2));
			ans = ans + recursiveWithMemo(str, index + 2, callStack);
			callStack.removeLast();
		}

		// Save for memoization
		memo.put(index, ans);

		return ans;
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		LinkedList<String> callStack = new LinkedList<>();
		return recursiveWithMemo(s, 0, callStack);
	}
}