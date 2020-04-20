package com.sree.programs.important.askedininterviews;
/*
https://www.geeksforgeeks.org/delete-occurrences-given-key-linked-list/
*/
public class LinkedListRemoveAll {
	private static class  Node {
	int value;
	Node next;
	Node(int value){
		this.value=value;
	}
}
public static void main(String[] args) {
	//3-->1-->2-->3-->3-->4-->3-->5
	Node node30=new Node(3);
	Node node1=new Node(1);
	Node node2=new Node(2);
	Node node3=new Node(3);
	Node node31=new Node(3);
	Node node4=new Node(4);
	Node node5=new Node(5);
	Node node32=new Node(3);
	Node head=node30;
	node30.next=node1;
	node1.next=node2;
	node2.next=node3;
	node3.next=node31;
	node31.next=node4;
	node4.next=node32;
	node32.next=node5;
	node5.next=null;
	print(head);
	 head=removeAll(head,3);
	print(head);
}
private static Node removeAll(Node head,int target) {
	
	
	while(head.value==target) {
		head=head.next;
	}
	Node current=head;
	Node previous=null;
	while(current!=null) {
		if(current.value==target) {
			previous.next=current.next;
			current=current.next;
		}else {
			previous=current;
			current=current.next;
		}
	}
	return head;
}
public static void print(Node head){
	Node current=head;
	while(current!=null) {
		System.out.print(current.value+"-->");
		current=current.next;
	}
	System.out.println();
}
}
