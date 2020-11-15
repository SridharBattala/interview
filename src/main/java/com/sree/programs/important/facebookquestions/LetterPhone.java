package com.sree.programs.important.facebookquestions;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
 */
import java.util.*;

class LetterPhone {
	static List<String> output = new ArrayList<String>();

	public static void main(String[] args) {

		letterCombinations("234");
		System.out.println("" + output.toString());
	}

	static Map<Character, String> phone = new HashMap<Character, String>();

	public static void backtrack(String combination, String digits, int digitsIndex) {
		// if there is no more digits to check
		if (digitsIndex == digits.length()) {
			// the combination is done
			output.add(combination);
			return;
		}
		// if there are still digits to check
		else {
			// iterate over all letters which map
			// the next available digit
			char digit = digits.charAt(digitsIndex);
			String letters = phone.get(digit);
			for (int lettersIndex = 0; lettersIndex < letters.length(); lettersIndex++) {
				char letter = phone.get(digit).charAt(lettersIndex);
				// append the current letter to the combination
				// and proceed to the next digits
				backtrack(combination + letter, digits, digitsIndex + 1);
			}
		}
	}

	public static List<String> letterCombinations(String digits) {
		phone.put('2', "abc");
		phone.put('3', "def");
		phone.put('4', "ghi");
		phone.put('5', "jkl");
		phone.put('6', "mno");
		phone.put('7', "pqrs");
		phone.put('8', "tuv");
		phone.put('9', "wxyz");
		if (digits.length() != 0)
			backtrack("", digits, 0);
		return output;
	}
}