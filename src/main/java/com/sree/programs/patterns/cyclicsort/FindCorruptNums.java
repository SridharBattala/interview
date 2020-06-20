package com.sree.programs.patterns.cyclicsort;

public class FindCorruptNums {
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
		System.out.println(nums[0] + ", " + nums[1]);

	}

	private static int[] findNumbers(int[] input) {
		int[] output = new int[2];
		// cyclic sort
		for (int i = 0; i < input.length; i++) {
			while (input[i] != input[input[i] - 1]) {
				swap(input, i, input[i] - 1);
			}
		}
		// check duplicate number
		for (int i = 0; i < input.length; i++) {
			if (input[i] != i + 1) {
				output[0] = i + 1;
				output[1] = input[i];
			}
		}
		return output;
	}

}
