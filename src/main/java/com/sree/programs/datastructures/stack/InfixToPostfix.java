package com.sree.programs.datastructures.stack;

import java.util.*;

/**
 * https://algorithms.tutorialhorizon.com/convert-infix-to-postfix-expression/
 * 
 * @author sbattala
 *
 */
public class InfixToPostfix {
	public static void main(String args[]) {
		String input = "A+B*(C^D-E)";
		System.out.println("input=" + input);
		String output = postfixConversion(input);
		System.out.println("output=" + output);
	}

	public static String postfixConversion(String input) {
		// precedence map
		Map<Character, Integer> precedenceMap = new HashMap<>();
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		precedenceMap.put('^', 3);

		// define stack
		Stack<Character> operatorStack = new Stack<>();
		// define result
		String output = "";
		for (int index = 0; index < input.length(); index++) {
			char ch = input.charAt(index);
			// check char is operator
			if (precedenceMap.containsKey(ch)) {
				// add all the elements to output until precedence of current element less than
				// stack top
				while (!operatorStack.isEmpty()
						&& precedenceMap.getOrDefault(operatorStack.peek(), 0) >= precedenceMap.getOrDefault(ch, 0)) {
					char top = operatorStack.pop();
					output = output + top;
				}
				operatorStack.push(ch);
			} else if (ch == ')') {
				// loop operator stack until reaches '('
				char top = operatorStack.pop();
				while (top != '(') {
					output = output + top;
					top = operatorStack.pop();
				}

			} else if (ch == '(') {
				operatorStack.push(ch);
			}
			// check char is operand
			else {
				output = output + ch;
			}
		}
		// add operator stack values to output
		for (int i = 0; i <= operatorStack.size(); i++) {
			output = output + operatorStack.pop();
		}
		return output;
	}
}
