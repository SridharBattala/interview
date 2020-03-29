package com.sree.leave.programs.patterns.slidingwindow;

public class MaxSumSubArray {
public static void main(String args[]) {
	int arr[]= {2,1,5,1,3,2};
	System.out.println(findMaxSumSubArray(arr,3));
}
public static int findMaxSumSubArray(int[] arr,int windowSize){
	int windowSum=0,maxSum=0;
	for(int i=0;i<arr.length;i++) {
		windowSum=windowSum+arr[i];
		if(i>=windowSize-1) {
			maxSum=Math.max(maxSum, windowSum);
			windowSum=windowSum-arr[i-(windowSize-1)];
		}
	}
	return maxSum;
}
}
