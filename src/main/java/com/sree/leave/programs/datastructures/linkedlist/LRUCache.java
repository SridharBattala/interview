package com.sree.leave.programs.datastructures.linkedlist;

/**
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://medium.com/@krishankantsinghal/my-first-blog-on-medium-583159139237
 * @author sridharbattala
 *
 */
/* We can use Java inbuilt Deque as a double 
ended queue to store the cache keys, with 
the descending time of reference from front 
to back and a set container to check presence 
of a key. But remove a key from the Deque using 
remove(), it takes O(N) time. This can be 
optimized by storing a reference (iterator) to 
each key in a hash map. */
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRUCache {
	// store keys of cache
	static Deque<Integer> dq;
	// store references of key in cache
	static HashSet<Integer> map;
	// maximum capacity of cache
	static int csize;

	LRUCache(int n) {
		dq = new LinkedList<>();
		map = new HashSet<>();
		csize = n;
	}

	/* Refers key x with in the LRU cache */
	public void refer(int x) {
		if (!map.contains(x)) {
			if (dq.size() == csize) {
				int last = dq.removeLast();
				map.remove(last);
			}
		} else {
			/*
			 * The found page may not be always the last element, even if it's an
			 * intermediate element that needs to be removed and added to the start of the
			 * Queue
			 */
			
			dq.remove(x);
		}
		dq.addFirst(x);
		map.add(x);
	}

	// display contents of cache
	public void display() {
		Iterator<Integer> itr = dq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRUCache ca = new LRUCache(3);
		//1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(5);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(4);
		ca.refer(5);
		ca.display();
	}
}
// This code is contributed by Gaurav Tiwari 
