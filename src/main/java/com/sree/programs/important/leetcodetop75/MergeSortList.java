package com.sree.programs.important.leetcodetop75;

public class MergeSortList {
	static class ListNode {
		ListNode next;
		int data;

		ListNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		// list1
		node1.next = node3;
		node3.next = node5;
		// list2
		node2.next = node4;
		node4.next = node6;
		node6.next = node7;
		node7.next = node8;
		ListNode head3Start = mergeLists(node1, node2);

		// print list3
		while (head3Start != null) {
			System.out.print(head3Start.data + "-->");
			head3Start = head3Start.next;
		}
	}

	private static ListNode mergeLists(ListNode head1, ListNode head2) {
		ListNode mergeTail = null;
		ListNode mergeHead = null;
		ListNode temp = null;
		// find head
		if (head1.data < head2.data) {
			mergeHead = head1;
		} else {
			mergeHead = head2;
		}
		mergeTail = mergeHead;
		// loop both the lists
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				System.out.println("conisder=" + head1.data);
				temp = head1;
				head1 = head1.next;
			} else {
				System.out.println("conisder=" + head2.data);
				temp = head2;
				head2 = head2.next;
			}
			mergeTail.next = temp;
			mergeTail = temp;
		}
		// loop remaining node in list1
		while (head1 != null) {
			System.out.println("conisder=" + head1.data);
			temp = head1;

			mergeTail.next = temp;
			mergeTail = temp;
			head1 = head1.next;
		}
		// loop remaining node in list1
		while (head2 != null) {
			System.out.println("conisder=" + head2.data);
			temp = head2;

			mergeTail.next = temp;
			mergeTail = temp;
			head2 = head2.next;
		}
		return mergeHead;
	}

}
