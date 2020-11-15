package com.sree.programs.important.askedininterviews;

/*
 * https://leetcode.com/discuss/interview-question/531404/balancing-elements
 */
public class PaypalBalancedArray {

	public static void main(String args[]) {
		int arr1[] = { 2, 1, 6, 4 };
		int arr[] = { 5, 5, 2, 5, 8 };
		// int arr[] = { 5, 5, 2, 5, 8 };
		int evenSum = 0, oddSum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				evenSum = evenSum + arr[i];
			} else {
				oddSum = oddSum + arr[i];
			}
		}
		System.out.println("even sum=" + evenSum);
		System.out.println("odd sum=" + oddSum);
		long leftEven = 0, leftOdd = 0;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				if (oddSum + leftEven == leftOdd + evenSum - arr[i]) {
					count++;
				}

				evenSum = evenSum - arr[i];
				leftEven = leftEven + arr[i];
			} else {
				if (evenSum + leftOdd == leftEven + oddSum - arr[i]) {
					count++;
				}

				oddSum = oddSum - arr[i];
				leftOdd = leftOdd + arr[i];
			}
		}

		// count++;
		System.out.println("output=" + count);

	}
}
