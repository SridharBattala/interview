package com.sree.programs.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=uzqKs5t9_gk
 * https://algorithms.tutorialhorizon.com/binary-min-max-heap/
 * @author sridharbattala
 *
 */
public class MinHeap {
	public static List<Integer> minHeap=new ArrayList<>();
public static void main(String[] args) {
	insert(20);
	insert(8);
	insert(15);
	insert(5);
	insert(2);
	insert(1);
	print();
	//insert(0);
	removeRoot();
	print();
}
private static void print() {
	for(Integer ele:minHeap) {
		System.out.print(ele+"-->");
	}
	System.out.println();
}
public static void removeRoot(){
	if(minHeap.isEmpty()) {
		return;
	}else if(minHeap.size()<=2){
		minHeap.remove(0);
	}else {
		//remove root element
		minHeap.remove(0);
		//remove last element and place in root
		int lastElement=minHeap.remove(minHeap.size()-1);
		minHeap.add(0,lastElement);
		//buuble down
		bubbleDown(0);
	
	}
}
private static void bubbleDown(int parentIndex) {
	while(true) {
		 int leftChildIndex=getLeftChildIndex(parentIndex);
		 int rightChildIndex=getRightChildIndex(parentIndex);
		 //parent don't have left or right child
		 if(leftChildIndex>minHeap.size()-1 && rightChildIndex>minHeap.size()-1) {
			 break;
		 }else if(leftChildIndex<=minHeap.size()-1 && rightChildIndex>minHeap.size()-1) {//parent having only left child
			 swap(parentIndex,leftChildIndex);
			 break;
		 }else {
			 if(minHeap.get(parentIndex)>minHeap.get(leftChildIndex) || minHeap.get(parentIndex)>minHeap.get(rightChildIndex)) {
				 int minIndex,min;
				 min=Math.min(minHeap.get(leftChildIndex), minHeap.get(rightChildIndex));
				 minIndex=minHeap.indexOf(min);
				 swap(parentIndex,minIndex);			 
				 parentIndex=minIndex;
			 } 
		 }
		
		 
		}
}
public static void insert(int element){
	if(minHeap.isEmpty()) {
		minHeap.add(element);
	}else {
		//add at last
		minHeap.add(element);
		//swap with parent
		int elementIndex=minHeap.indexOf(element);
		int parentIndex=getParentIndex(elementIndex);
		if(parentIndex==-1) {
			return;
		}
		int parent=minHeap.get(parentIndex);
		if(parent>element) {
			swap(parentIndex,elementIndex);
			elementIndex=parentIndex;
			//bubble down
			 parentIndex=getParentIndex(elementIndex);
			 bubbleUp(parentIndex,elementIndex);
			
		}
		
	}
}

private static void bubbleUp(int parentIndex, int elementIndex) {
	
	while(parentIndex>-1 && minHeap.size()>(2*parentIndex)+2) {
		 int leftChildIndex=getLeftChildIndex(parentIndex);
		 int rightChildIndex=getRightChildIndex(parentIndex);
		 int minIndex,min;
		 if(minHeap.get(parentIndex)>minHeap.get(leftChildIndex) || minHeap.get(parentIndex)>minHeap.get(rightChildIndex)) {
			 min=Math.min(minHeap.get(leftChildIndex), minHeap.get(rightChildIndex));
			 swap(parentIndex,minHeap.indexOf(min));
			 elementIndex=parentIndex;
			 parentIndex=getParentIndex(elementIndex);
		 }
		}
}

private static int getRightChildIndex(int index) {
	return (2*index)+2; 
}
private static int getLeftChildIndex(int index) {
	// TODO Auto-generated method stub
	return (2*index)+1;
}
private static void swap(int parentIndex, int elementIndex) {
	int temp=minHeap.get(parentIndex);
	minHeap.set(parentIndex, minHeap.get(elementIndex));
	minHeap.set(elementIndex, temp);
}
private static int getParentIndex(int index) {
	//n/2-1
	if(index==0) {
		return -1;
	}
	return (index-1)/2;
	
}
}
