package com.sree.programs.datastructures.java;

import java.util.*;

public class JavaArrayList {
	public static void main(String[] args) {
		/**
		 * linked list
		 */
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.remove(1);// remove the element in index 1
		arrayList.contains(1);
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list1.retainAll(list2);
		System.out.println("list 1 retain all= " + list1.toString());

	}
}
