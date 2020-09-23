package com.sree.programs.important.leetcodetop75;

public class RearrangeLinkedList {
	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	// 1)find middle of list
	// 2)reverse the second half
	// 3)traverse both first of head and second half head, then build the order
	private static void reorder(ListNode head) {
		// 1)find middle of list
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode firstHalfHead = head;
		ListNode secondHalfHead = reverse(slow);
		System.out.println("firstHalfHead=" + firstHalfHead.value);
		System.out.println("secondHalfHead=" + secondHalfHead.value);

		// loop both heads
		while (firstHalfHead != null && secondHalfHead != null) {
			System.out.println("loop firstHalfHead=" + firstHalfHead.value);
			System.out.println("loop secondHalfHead=" + secondHalfHead.value);
			ListNode firstHalfNext = firstHalfHead.next;
			ListNode secondHalfNext = secondHalfHead.next;

			firstHalfHead.next = secondHalfHead;
			secondHalfHead.next = firstHalfNext;

			firstHalfHead = firstHalfNext;
			secondHalfHead = secondHalfNext;
		}
		System.out.println("loop out firstHalfHead=" + firstHalfHead.value);
		// System.out.println("loop out secondHalfHead=" + secondHalfHead != null ?
		// secondHalfHead.value : null);
		if (firstHalfHead != null) {
			firstHalfHead.next = null;
		}
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
