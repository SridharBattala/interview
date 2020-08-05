package com.sree.programs.datastructures.strings;

import java.util.*;

class ReverseWords {
	public String reverseWords(String input) {
		// reverse string
		// split the string with space and reverse each word and concatenate

		input = input.trim();
		char[] reverseArr = reverse(input.toCharArray(), 0, input.length() - 1);
		System.out.println("reverse= " + Arrays.toString(reverseArr));
		// split array by space
		int start = 0, end = 0, index = 0;
		while (true) {
			while (start < reverseArr.length && reverseArr[start] == ' ') {
				start++;
			}
			if (start >= reverseArr.length) {
				break;
			}
			end = start + 1;
			while (end < reverseArr.length && reverseArr[end] != ' ') {
				end++;
			}
			reverse(reverseArr, start, end - 1);
			start = end;
		}
		return new String(reverseArr);
	}

	public static char[] reverse(char[] inputArr, int startIndex, int endIndex) {
		System.out.println("start= " + startIndex + ", endIndex=" + endIndex);
		for (int start = startIndex, end = endIndex; start <= end; start++, end--) {
			// swap
			char temp = inputArr[start];
			inputArr[start] = inputArr[end];
			inputArr[end] = temp;
		}
		return inputArr;
	}
}
