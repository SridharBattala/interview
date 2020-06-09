package com.sree.programs.datastructures.stack;

import java.util.*;

/**
 * https://algorithms.tutorialhorizon.com/evaluation-of-postfix-expressions-polish-postfix-notation-set-1/
 * 
 * @author sbattala
 *
 */
public class EvaluatePostfix {
	public static void main(String args[]) {
		String input = "1+2*(3^4-5)";
		System.out.println("input=" + input);
		String output = postfixConversion(input);
		System.out.println("output=" + output);
		// output=1234^5-*+
		System.out.println("sum=" + evaluatePostfix(output));
	}

	public static double evaluatePostfix(String postfixExpression) {
		Stack<Double> operandsStack = new Stack<>();
		// precedence map
		Map<Character, Integer> precedenceMap = new HashMap<>();
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		precedenceMap.put('^', 3);
		double sum = 0.0;
		for (int index = 0; index < postfixExpression.length(); index++) {
			Character ch = postfixExpression.charAt(index);
			// check for operator
			if (!operandsStack.isEmpty() && precedenceMap.containsKey(ch)) {
				sum = evaulate(operandsStack.pop(), operandsStack.pop(), ch);
				operandsStack.push(sum);
			}
			// operand
			else {
				operandsStack.push((double) ch - '0');
			}
		}
		return sum;
	}

	private static Double evaulate(double operand1, double operand2, char operator) {
		switch (operator) {
		case '+':
			return operand2 + operand1;
		case '-':
			return operand2 - operand1;
		case '*':
			return operand2 * operand1;
		case '/':
			if (operand1 == 0) {
				throw new UnsupportedOperationException();
			}
			return operand2 / operand1;
		case '^':
			return Math.pow(operand2, operand1);

		}
		return 0.0;
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
