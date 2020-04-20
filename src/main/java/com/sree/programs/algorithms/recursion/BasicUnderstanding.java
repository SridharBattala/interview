package com.sree.programs.algorithms.recursion;

public class BasicUnderstanding {
public static void main(String[] args) {
	printNumbersIterative(1,5);
	printNumbersRecursion(1,5);
}

private static void printNumbersIterative(int start, int end) {
	for(int i=start;i<=end;i++) {
		System.out.print(i+"-->");
	}
	System.out.println();
}

private static void printNumbersRecursion(int start, int end) {
	
	helper(start,end);
}

private static void helper(int current, int end) {
	//base case
	if(current>end) {
		return;
	}
	// recursive case
	else {
		System.out.print(current+"-->");
		helper(current+1,end);
	}

}
}
