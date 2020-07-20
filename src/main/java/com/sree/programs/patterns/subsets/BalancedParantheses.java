package com.sree.programs.patterns.subsets;

import java.util.*;

class Parentheses {
	String str;
	int openCount;
	int closeCount;

	Parentheses(String str, int openCount, int closeCount) {
		this.str = str;
		this.openCount = openCount;
		this.closeCount = closeCount;
	}
}

public class BalancedParantheses {
	// create parentheses class with string,open count,close count
	// add empty string to queue
	// for every value in queue,
	// add ( if not more than N and add ) if open count >close count until empty
	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<String>();
		Queue<Parentheses> queue = new LinkedList<>();
		queue.add(new Parentheses("", 0, 0));
		while (!queue.isEmpty()) {
			Parentheses current = queue.poll();
			if (current.openCount == num && current.closeCount == num) {
				result.add(current.str);
			} else {
				if (current.openCount < num) {
					queue.add(new Parentheses(current.str + "(", current.openCount + 1, current.closeCount));
				}
				if (current.openCount > current.closeCount) {
					queue.add(new Parentheses(current.str + ")", current.openCount, current.closeCount + 1));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> result = generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}
}
