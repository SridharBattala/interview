package com.sree.programs.patterns.fastandslowpointers;

public class LinkedListCycleStart {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

	}

	private static ListNode findCycleStart(ListNode head) {
		// check for cycle
		ListNode start = null;
		ListNode slow = head;
		ListNode fast = head;
		boolean cycleExists = false;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				cycleExists = true;
				break;
			}

		}
		System.out.println("cycleExists=" + cycleExists);
		// if cycle exists find cycle length
		int cycleLength = 0;
		if (cycleExists) {
			ListNode current = slow;
			do {
				cycleLength++;
				current = current.next;
			} while (current != slow);

		}
		System.out.println("cycleLength=" + cycleLength);
		// find start now
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		// move pointer 2 to cycle length ahead
		int currentLength = 1;
		while (cycleLength >= currentLength) {
			pointer2 = pointer2.next;
			currentLength++;
		}
		while (pointer1 != null && pointer2 != null) {
			if (pointer1 == pointer2) {
				start = pointer1;
				break;
			}
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return start;
	}
}
