package com.sree.leave.programs.datastructures.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueClassInJava {
	
		public static void main(String[] args) {
			Queue<Integer> queue=new LinkedList<>();
			queue.add(1);
			queue.add(2);
			queue.add(3);
			queue.add(4);
			queue.add(5);
			queue.remove();
			System.out.println(queue);
			queue.remove();
			System.out.println(queue);
		}
	
}
