package com.sree.programs.patterns.twoheaps;

import java.util.*;

class MedianOfAStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

	public static void main(String[] args) {
		MedianOfAStream medianOfAStream = new MedianOfAStream();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}

	private double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
		}
		return maxHeap.peek();
	}

	private void insertNum(int num) {
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		}
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
}
