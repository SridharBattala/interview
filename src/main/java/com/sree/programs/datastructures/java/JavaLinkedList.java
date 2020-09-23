package com.sree.programs.datastructures.java;

import java.util.*;

public class JavaLinkedList {
	public static void main(String[] args) {
		/**
		 * linked list
		 */
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.remove(1);// remove the element in index 1

		linkedList.removeFirst();// removes first element of list
		linkedList.removeLast();
		linkedList.addLast(3);
		linkedList.addFirst(3);

		linkedList.isEmpty();
		linkedList.size();

		/**
		 * list to array
		 */
		Integer[] listArray1 = (Integer[]) linkedList.toArray();
		Integer[] listArray2 = linkedList.toArray(new Integer[linkedList.size()]);

		/**
		 * list to two dimensional array
		 */
		List<List<Integer>> list1 = new ArrayList<>();
		list1.add(Arrays.asList(1, 2, 3));
		list1.add(Arrays.asList(4, 5, 6));
		int[][] arr = list1.toArray(new int[list1.size()][3]);

		/**
		 * list sort
		 */
		List<Integer> list = Arrays.asList(2, 1, 3, 5, 4);
		Collections.sort(list);
		Collections.sort(list, Collections.reverseOrder());
		class Employee {
			int id;
			String name;

			Employee(int id, String name) {
				this.id = id;
				this.name = name;
			}
		}
		List<Employee> empList = new LinkedList<>();
		empList.add(new Employee(1, "sridhar"));
		empList.add(new Employee(2, "pravali"));
		Collections.sort(empList, (a, b) -> (a.id - b.id));

	}
}
