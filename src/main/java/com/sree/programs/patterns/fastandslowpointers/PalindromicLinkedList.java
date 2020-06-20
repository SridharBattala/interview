package com.sree.programs.patterns.fastandslowpointers;

class PalindromicLinkedList {

	public static boolean isPalindrome(ListNode head) {
		// find middle
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// reverse second half
		ListNode secondHalfHead = reverse(slow);
		ListNode copyOfSecondHalfHead = secondHalfHead;
		ListNode firstHalfHead = head;
		// compare both first half and second half
		while (firstHalfHead != null && secondHalfHead != null) {
			if (firstHalfHead.value != secondHalfHead.value) {
				break;
			}
			firstHalfHead = firstHalfHead.next;
			secondHalfHead = secondHalfHead.next;
		}
		reverse(copyOfSecondHalfHead);
		if (firstHalfHead == null && secondHalfHead == null) {
			return true;
		}
		return false;
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.value + "-->");
			head = head.next;
		}
		System.out.println();
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
	}
}
