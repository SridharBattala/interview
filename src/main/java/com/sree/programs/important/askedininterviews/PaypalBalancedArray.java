package com.sree.programs.important.askedininterviews;

/*
 * https://leetcode.com/discuss/interview-question/531404/balancing-elements
 */
public class PaypalBalancedArray {

	public static void main(String args[]) {
		int arr[] = { 2, 1, 100, 6, 4 };

		int odd = 0, even = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				even += arr[i];
			else
				odd += arr[i];
		}
		int ans = 0;
		int prevOdd = 0, prevEven = 0;
		for (int i = 0; i < arr.length; i++) {
			int x = even - prevEven;
			int y = odd - prevOdd;
			if (i % 2 == 0)
				x -= arr[i];
			else
				y -= arr[i];
			if (prevOdd + x == prevEven + y)
				ans++;
			if (i % 2 == 0)
				prevEven += arr[i];
			else
				prevOdd += arr[i];
		}
		System.out.println(ans);
	}

}
