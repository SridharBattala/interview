package com.sree.programs.datastructures.java;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {
	public static void main(String[] args) {
		/**
		 * queue
		 */
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.poll();
		queue.peek();
		queue.isEmpty();
		queue.size();
	}
}
