
package com.sree.leave.programs.datastructures.arrays;

import java.util.Arrays;
/**
 * 
 * Write a function that takes in two non-empty arrays of integers. 
*The function should find the pair of numbers (one from the first array, one from the second array) whose absolute difference 
*is closest to zero. The function should return an array containing these two numbers, with the number from the first array 
*		in the first position. Assume that there will only be one pair of numbers with the smallest difference.

*Sample input: [-1, 5, 10, 20, 28, 3], [26, 134, 135, 15, 17]
*Sample output: [28, 26]
 *
 */
public class SmallestDifferenceAE {
	// O(n log(n) + m log(m)) time | O(1) space
	  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
	    Arrays.sort(arrayOne);
	    Arrays.sort(arrayTwo);
	    int idxOne = 0;
	    int idxTwo = 0;
	    int smallest = Integer.MAX_VALUE;
	    int current = Integer.MAX_VALUE;
	    int[] smallestPair = new int[2];
	    while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
	      int firstNum = arrayOne[idxOne];
	      int secondNum = arrayTwo[idxTwo];
	      if (firstNum < secondNum) {
	        current = secondNum - firstNum;
	        idxOne++;
	      } else if (secondNum < firstNum) {
	        current = firstNum - secondNum;
	        idxTwo++;
	      } else {
	        return new int[] {firstNum, secondNum};
	      }
	      if (smallest > current) {
	        smallest = current;
	        smallestPair = new int[] {firstNum, secondNum};
	      }
	    }
	    return smallestPair;
	  }
	}

	

