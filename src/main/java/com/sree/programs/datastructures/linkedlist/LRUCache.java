package com.sree.programs.datastructures.linkedlist;

//Linked list operations
//LinkedListNode(int data) 
//LinkedListNode(int key, int data)
//LinkedListNode(int data, LinkedListNode next)
//LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitrary_pointer)
/**
 * https://www.educative.io/courses/coderust-hacking-the-coding-interview/jRLoR
 * https://www.algoexpert.io/questions/LRU%20Cache
 */
import java.util.*;

class LRUCache {
	class LinkedListNode {
		int key;
		String value;

		LinkedListNode(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	int capacity;

//LinkedListNode holds key and value pairs
	Map<Integer, LinkedListNode> cacheMap;
	LinkedList<LinkedListNode> cacheList;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<Integer, LinkedListNode>(capacity);
		cacheList = new LinkedList<LinkedListNode>();
	}

	String get(int key) {
		if (!cacheMap.containsKey(key)) {
			return null;
		} else {
			// remove from current position and add last
			LinkedListNode node = cacheMap.get(key);
			cacheList.remove(node);
			cacheList.addLast(node);
			return node.value;
		}
	}

	void set(int key, String value) {
		// if contains key
		if (cacheMap.containsKey(key)) {
			LinkedListNode node = cacheMap.get(key);
			node.value = value;
			cacheList.remove(node);
			cacheList.addLast(node);

		} else {
			// remove head if size>=capacity
			if (cacheList.size() >= capacity) {
				LinkedListNode headNode = cacheList.remove();
				cacheMap.remove(headNode.key);
			}

			// add last
			LinkedListNode node = new LinkedListNode(key, value);
			cacheList.addLast(node);
			cacheMap.put(key, node);
		}
	}

	void print() {

		for (LinkedListNode node : cacheList) {
			System.out.print("(" + node.key + "," + node.value + ")");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);

		cache.set(1, "sridhar");
		cache.set(2, "balu");
		cache.set(3, "ashok");
		cache.print();

		cache.get(1);
		cache.set(4, "krish");
		cache.print();

		cache.set(5, "abhi");
		cache.print();
	}
}
