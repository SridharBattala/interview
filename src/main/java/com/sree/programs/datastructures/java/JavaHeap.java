package com.sree.programs.datastructures.java;

import java.util.PriorityQueue;

public class JavaHeap {
	public static void main(String[] args) {
		/**
		 * priority queue - frequency sort example
		 */
		class Frequecy {
			char ch;
			int count;

			Frequecy(char ch, int count) {
				this.ch = ch;
				this.count = count;

			}
		}

		PriorityQueue<Frequecy> heap = new PriorityQueue<>((a, b) -> b.count - a.count);

		heap.offer(new Frequecy('a', 2));
		heap.offer(new Frequecy('b', 1));
		heap.offer(new Frequecy('c', 3));
		heap.poll();
		heap.peek();
		heap.isEmpty();
		System.out.println(heap.peek());
	}
}
