package com.sree.programs.datastructures.heap;
/*
 * https://www.geeksforgeeks.org/heap-sort/
 */
public class HeapSort {
	/*
	 *  Target Practice 09 - Heapsort
	 */

	'use strict';

	/*
	 *  Heapsort
	 *
	 *  Prompt:    Given an unsorted array of integers, return the array
	 *             sorted using heapsort.
	 *
	 *  Input:     input {Array}
	 *  Output:    {Array}
	 *
	 *  Example:   [3,9,1,4,7] --> [1,3,4,7,9]
	 */


	// Worse Time Complexity: O(Nlog(N))
	// Worse Auxiliary Space Complexity: O(1)
	// Average Time Complexity: O(Nlog(N))
	// Average Auxiliary Space Complexity: O(1)

	function heapsort(arr) {
	  let heapLength = 1;
	  
	  function getParent(child) {
	    return Math.floor((child - 1) / 2);
	  }
	  
	  function getChild(parent) {
	    let leftChild = parent*2 + 1;
	    let rightChild = leftChild + 1;
	    
	    if(leftChild >= heapLength - 1 || arr[leftChild] >= arr[rightChild]) {
	      return leftChild;
	    }
	    return rightChild;
	  }
	  
	  function bubbleDown() {
	    let parent = 0;
	    let child = getChild(parent);
	    
	    while(child < heapLength && arr[parent] < arr[child]) {
	      [arr[parent], arr[child]] = [arr[child], arr[parent]];
	      parent = child;
	      child = getChild(parent);
	    }
	  }
	  
	  function bubbleUp() {
	    let child = heapLength - 1;
	    let parent = getParent(child);
	    
	    while (child > 0 && arr[parent] < arr[child]) {
	      [arr[child], arr[parent]] = [arr[parent], arr[child]];
	      child = parent;
	      parent = getParent(child); 
	    } 
	  }
	  
	  function remove() {
	    [arr[0], arr[heapLength - 1]] = [arr[heapLength - 1], arr[0]];
	    heapLength--;
	    bubbleDown();
	  }
	  
	  function insert() {
	    heapLength++;
	    bubbleUp();
	  }
	  
	  while (heapLength < arr.length) {
	    insert();
	  }
	  
	  console.log("HEAPIFIED ARRAY: ");
	  console.log(arr);
	  
	  while(heapLength > 1) {
	    remove();
	  }

	  console.log("SORTED ARRAY: ");
	  return arr;
	  
	}

	let array = [4,15,16,50,8,23,42,108];

	console.log("UNSORTED ARRAY: ");
	console.log(array);
	console.log(heapsort(array));








}
