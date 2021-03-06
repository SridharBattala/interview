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
		String input = "1+2*(3^4-5)";
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
			// check for operator
			if (precedenceMap.containsKey(ch)) {
				while (!operatorStack.isEmpty()
						&& precedenceMap.get(ch) < precedenceMap.getOrDefault(operatorStack.peek(), 0)) {
					output = output + operatorStack.pop();

				}
				operatorStack.push(ch);
			}
			// check for ')'
			else if (ch == ')') {
				while (operatorStack.peek() != '(') {
					output = output + operatorStack.pop();

				}
				// remove (
				operatorStack.pop();
			} else if (ch == '(') {
				operatorStack.push('(');
			}
			// check for operand
			else {
				output = output + ch;
			}
		}
		// loop operator stack and add to output
		int size = operatorStack.size();
		for (int i = 0; i < size; i++) {
			output = output + operatorStack.pop();
		}

		return output;
	}
}
