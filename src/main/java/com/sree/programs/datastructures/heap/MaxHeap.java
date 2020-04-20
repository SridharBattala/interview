package com.sree.programs.datastructures.heap;

import java.util.Arrays;

class MaxHeap {
 
	private void maxHeapify(int[] heapArray, int index, int heapSize){
		System.out.println("maxHeapify index="+index+", ele="+heapArray[index]);
		int largest = index;
		while (largest < heapSize / 2){      // check parent nodes only   
			int left = (2 * index) + 1;       //left child
			int right = (2 * index) + 2;      //right child

			if (left < heapSize && heapArray[left] > heapArray[index]){
				System.out.println("maxHeapify left="+heapArray[left]);

				largest = left; 			
      		}
			if (right < heapSize && heapArray[right] > heapArray[largest]){
				System.out.println("maxHeapify right="+heapArray[right]);

				largest = right;
			}
			if (largest != index){ // swap parent with largest child 
				int temp = heapArray[index];
				heapArray[index] = heapArray[largest];
				heapArray[largest] = temp;
				index = largest;
			}
      		else 
				break; // if heap property is satisfied 
		} //end of while
	} 
	public void buildMaxHeap(int[] heapArray, int heapSize) 
  	{
		System.out.println("buildMaxHeap heapSize="+heapSize);
   	// swap largest child to parent node 
		for (int i = (heapSize - 1) / 2; i >= 0; i--){
			maxHeapify(heapArray, i, heapSize);
		}
	}
	
	public static void main(String[] args) {
		int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		
		System.out.println("Before heapify: "+Arrays.toString(heapArray));		
		new MaxHeap().buildMaxHeap(heapArray, heapArray.length);
		System.out.println("After heapify: "+Arrays.toString(heapArray));		
	}
}
