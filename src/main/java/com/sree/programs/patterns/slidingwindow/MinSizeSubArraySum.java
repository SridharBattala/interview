package com.sree.leave.programs.patterns.slidingwindow;

public class MinSizeSubArraySum {
public static void main(String args[]) {
	int arr[]= {2,1,5,2,3,2};
	System.out.println(findMinSizeSubArraySum(arr,7));
}
public static int findMinSizeSubArraySum(int[] arr,int sum){
	int windowSum=0,minLength=Integer.MAX_VALUE;
	int windowStart=0;
	int windowEnd=0;
	for(int i=0;i<arr.length;i++) {
		windowSum=windowSum+arr[i];
		windowEnd=i;
		while(windowSum>=sum) {
			minLength=Math.min(minLength, windowEnd-windowStart+1);
			windowSum=windowSum-arr[windowStart];
			
			windowStart=windowStart+1;
		}
	}
	return minLength;
}
}
