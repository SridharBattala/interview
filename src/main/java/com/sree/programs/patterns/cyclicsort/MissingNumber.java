package com.sree.leave.programs.patterns.cyclicsort;

import java.util.Arrays;

public class MissingNumber {
	public static int findMissingNumber(int[] nums) {
		int missingNumber=-1;
		  for(int i=0;i<nums.length;i++) {
			  while(nums[i]<nums.length && i<nums.length && !(i==nums[i]) ) {				  
					  swap(nums,i,nums[i]); 				  
					  System.out.println(Arrays.toString(nums));
			  }	
		  }
		  for (int i = 0; i < nums.length; i++) {
		      if (nums[i] != i) {
		    	  missingNumber=i;
		      }
		  }
		        return missingNumber;
	}
	private static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }

	  public static void main(String[] args) {
	    System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
	  }
}
