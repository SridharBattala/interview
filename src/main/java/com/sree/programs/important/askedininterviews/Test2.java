package com.sree.programs.important.askedininterviews;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		System.out.println("output=" + solution(268));
	}

	public static int solution(int n) {
		List<Integer> list = new ArrayList<>();
		int n1 = n;
		while (n1 > 0) {
			list.add(n1 % 10);
			n1 = n1 / 10;
		}
		Collections.reverse(list);

		if (n > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (5 >= list.get(i)) {
					list.add(i, 5);
					break;
				}
			}
		} else if (n < 0) {
			for (int i = 0; i < list.size(); i++) {
				if (5 <= list.get(i)) {
					list.add(i, 5);
					break;
				}
			}
		} else {
			return 50;
		}
		// sum
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			int sum1 = 1;
			for (int j = list.size() - 1; j > i; j--) {
				sum1 = sum1 * 10;
			}
			sum = sum + list.get(i) * sum1;
		}
		return sum;
	}

}
