package com.sree.leave.programs.algorithms.searching;
/**
 * https://www.geeksforgeeks.org/binary-search/
 * ae
 * @author sridharbattala
 *
 */
class BinarySearchAE { 
	// Returns index of x if it is present in arr[], 
	// else return -1 
	int binarySearch(int arr[], int target,int left,int right ) 
	{
		while(left<=right) {
			int middle=(left+right)/2;
			if(arr[middle]==target) {
				return middle;
			}
			if(target>arr[middle]) {
				left=middle+1;
			}else {
				right=middle-1;
			}
		}
		return -1;
	} 

	// Driver method to test above 
	public static void main(String args[]) 
	{ 
		BinarySearchAE ob = new BinarySearchAE(); 
		int arr[] = { 2, 3, 4, 10, 40 }; 
		int target = 10; 
		int result = ob.binarySearch(arr, target,0,arr.length-1); 
		if (result == -1) 
			System.out.println("Element not present"); 
		else
			System.out.println("Element found at "
							+ "index " + result); 
	} 
} 
