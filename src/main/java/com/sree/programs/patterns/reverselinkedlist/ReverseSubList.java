package com.sree.programs.patterns.reverselinkedlist;

class ReverseSubList {
	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}

	public static ListNode reverse(ListNode head, int start, int end) {
		if (start == end) {
			return head;
		} else {
			// four pointers
			ListNode startNodePrev = null;
			ListNode startNode = null;
			ListNode endNode = null;
			ListNode endNodeNext = null;

			for (int i = 1; head != null; i++) {
				if (i == start - 1) {
					startNodePrev = head;
					startNode = head.next;
					break;
				}
				head = head.next;
			}
			// three pointers
			ListNode prev = startNode;
			ListNode current = startNode.next;
			ListNode next = null;
			int currentCount = start;
			while (current != null) {

				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				currentCount++;
				if (currentCount == end) {
					endNode = prev;
					endNodeNext = current;
					break;
				}
			}
			// make it start node proper
			if (startNodePrev != null && endNode != null) {
				startNodePrev.next = endNode;
			}
			// make it end node proper
			if (startNode != null && endNodeNext != null) {
				startNode.next = endNodeNext;
			}
			return head;
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = ReverseSubList.reverse(head, 2, 4);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}