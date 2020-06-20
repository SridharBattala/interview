package com.sree.programs.patterns.subsets;

import java.util.*;

class ParenthesesString {
	String str;
	int openCount; // open parentheses count
	int closeCount; // close parentheses count

	public ParenthesesString(String s, int openCount, int closeCount) {
		str = s;
		this.openCount = openCount;
		this.closeCount = closeCount;
	}
}

public class GenerateParentheses {
	public static void main(String[] args) {
		List<String> result = GenerateParentheses.generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = GenerateParentheses.generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

	private static List<String> generateValidParentheses(int target) {
		Queue<ParenthesesString> queue = new LinkedList<>();
		// add empty string to queue
		List<String> output = new LinkedList<>();
		queue.add(new ParenthesesString("", 0, 0));
		while (!queue.isEmpty()) {
			ParenthesesString parenthesesString = queue.poll();
			if (parenthesesString.openCount == target && parenthesesString.closeCount == target) {
				output.add(parenthesesString.str);
			}
			if (parenthesesString.openCount < target) {
				queue.add(new ParenthesesString(parenthesesString.str + "(", parenthesesString.openCount + 1,
						parenthesesString.closeCount));
			}
			if (parenthesesString.closeCount < parenthesesString.openCount) {
				queue.add(new ParenthesesString(parenthesesString.str + ")", parenthesesString.openCount,
						parenthesesString.closeCount + 1));

			}

		}
		return output;
	}

}
