package com.sree.leave.programs.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java program to generate power set 
class PowerSetAE { 

//str : Stores input string 
//curr : Stores current subset 
//index : Index in current subset, curr 
static void powerSet(int[] arr, int index, 
		List<Integer> currArr) 
	
{ 
	System.out.println("arr="+Arrays.toString(arr)+", index="+index+", currArr="+currArr.toString());


	// base case 
	if (index == arr.length) 
	{ 
		System.out.println(currArr.toString()); 
		return; 
	} 

	// Two cases for every character 
	// (i) We consider the character 
	// as part of current subset 
	// (ii) We do not consider current 
	// character as part of current 
	// subset 
	List<Integer> currArr1=new ArrayList<>(currArr);
	currArr1.add(arr[index]);	
	powerSet(arr, index + 1, currArr1); 
	powerSet(arr, index + 1, currArr); 

} 

//Driver code 
public static void main(String[] args) 
{ 
	int[] arr = {1,2,3}; 
		int index = 0; 
		List<Integer> currArr=new ArrayList<>();
	powerSet(arr,index,currArr); 

	} 
} 
//This code is contributed by 29AjayKumar 

