package com.sree.programs.patterns.reverselinkedlist;

class ReverseEveryKElements {
	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.value + "-->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverse(ListNode head, int k) {

		ListNode reverseStart = head;
		ListNode reverseStartBefore = null;

		ListNode prev = head;
		ListNode current = head.next;
		ListNode next = null;
		int currentCount = 1;
		while (current != null) {

			currentCount++;

			// reverse logic
			next = current.next;
			current.next = prev;
			prev = current;

			if (currentCount == k) {
				head = current;
				// intially reverseStartBefore will be null , so assigning reverseStart
				reverseStartBefore = reverseStart;
				reverseStartBefore.next = next;

				reverseStart = next;
				print(head);
			}
			if (currentCount > k && currentCount % k == 0) {
				// map first

				reverseStartBefore.next = current;
				reverseStart.next = next;

				// change next
				reverseStartBefore = reverseStart;
				reverseStart = next;
				print(head);
			}
			if (next == null) {
				// map first
				reverseStartBefore.next = current;
				reverseStart.next = next;
				break;
			}
			current = next;

		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = ReverseEveryKElements.reverse(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
