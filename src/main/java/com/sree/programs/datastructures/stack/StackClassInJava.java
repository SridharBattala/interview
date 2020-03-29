package com.sree.leave.programs.datastructures.stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackClassInJava {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
}
