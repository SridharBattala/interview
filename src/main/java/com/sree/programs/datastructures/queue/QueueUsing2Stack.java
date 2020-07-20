package com.sree.programs.datastructures.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stack {
	private static Stack<Integer> stack1 = new Stack<>();
	private static Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {

		offer(1);
		offer(2);
		offer(3);

		poll();
		offer(4);
		print();
	}

	// O(n)
	public static void offer(int value) {
		if (stack1.isEmpty()) {
			stack1.add(value);
		} else {
			// copy stack1 values to stack2 and add current value to stack2, then add back
			// to stack1

		}
	}

	// O(1)
	public static int poll() {
		return stack1.pop();
	}

	public static int peek() {
		return 0;
	}

	public static boolean empty() {
		return true;
	}

	public static void print() {

	}
}
