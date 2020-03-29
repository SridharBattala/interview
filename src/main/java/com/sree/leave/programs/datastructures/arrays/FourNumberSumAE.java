package com.sree.leave.programs.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * sample input : [7,6,4,-1,1,2], 16
 *
 *sample output : [7,6,4,-1], [7,6,1,2]
 */
public class FourNumberSumAE {
	public static void main(String[] args) {
		int[] input=new int[] {7,6,4,-1,1,2};
		//fourNumberSumAE(input, 16);
		List<List<Integer>> output=fourNumberSum(input, 16);
		System.out.println(output.toString());
	}

	public static List<List<Integer>> fourNumberSum(int[] array, int targetSum) {
		List<List<Integer>> quadruplets = new ArrayList<>();
		Arrays.sort(array);
		for (int i = 0; i < array.length-3; i++) {
			for (int j = i+1; j < array.length-2; j++) {
				int left = j + 1;
				int right = array.length - 1;
				while (left < right) {
					int sum = array[i] + array[j] + array[left] + array[right];
					if (sum == targetSum) {
						quadruplets.add(Arrays.asList(array[i] , array[j] , array[left] , array[right]));
						left++;
						right--;
					} else if (sum > targetSum) {
						right--;
					} else if (sum < targetSum) {
						left++;
					}
				}
			}
		}
		return quadruplets;
	}
	// Average: O(n^2) time | O(n^2) space
	// Worst: O(n^3) time | O(n^2) space
	public static List<Integer[]> fourNumberSumAE(int[] array, int targetSum) {
		Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
		List<Integer[]> quadruplets = new ArrayList<Integer[]>();
		for (int i = 1; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int currentSum = array[i] + array[j];
				int difference = targetSum - currentSum;
				if (allPairSums.containsKey(difference)) {
					for (Integer[] pair : allPairSums.get(difference)) {
						Integer[] newQuadruplet = { pair[0], pair[1], array[i], array[j] };
						quadruplets.add(newQuadruplet);
					}
				}
			}
			for (int k = 0; k < i; k++) {
				int currentSum = array[i] + array[k];
				Integer[] pair = { array[k], array[i] };
				if (!allPairSums.containsKey(currentSum)) {
					List<Integer[]> pairGroup = new ArrayList<Integer[]>();
					pairGroup.add(pair);
					allPairSums.put(currentSum, pairGroup);
				} else {
					allPairSums.get(currentSum).add(pair);
				}
			}
		}
		return quadruplets;
	}
}
