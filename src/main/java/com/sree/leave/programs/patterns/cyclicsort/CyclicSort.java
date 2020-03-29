package com.sree.leave.programs.patterns.cyclicsort;

import java.util.Arrays;

class CyclicSort {

	  public static void sort(int[] nums) {
		  for(int i=0;i<nums.length;i++) {
			  while(i<nums.length && !((i+1)==nums[i])) {				  
					  swap(nums,i,nums[i]-1); 				  
					  System.out.println(Arrays.toString(nums));
			  }	
		  }
	  }
	  private static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }
	  public static void main(String[] args) {
	    int[] arr = new int[] { 2,6,4,3,1,5 };
	    CyclicSort.sort(arr);
	    for (int num : arr)
	      System.out.print(num + " ");

	    
	  }
	}

