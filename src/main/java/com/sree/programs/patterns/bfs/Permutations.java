package com.sree.programs.patterns.bfs;
import java.util.*;

import com.sree.programs.datastructures.matrix.MatrixHelper;
public class Permutations {
	
	
	
public static void main(String args[]) {
	 List<Integer> input=new ArrayList<>();
	input.add(1);
	input.add(2);
	input.add(3);
	Queue<List<Integer>> queue=printPermutations(input);
	MatrixHelper.print(queue);
}
public static  Queue<List<Integer>> printPermutations(List<Integer> input) {
	//define queue
	Queue<List<Integer>> queue=new LinkedList<>();
	List<Integer> list=new ArrayList<>();
	list.add(input.get(0));
	queue.add(list);
	int currentLevel=1;
	while(!queue.isEmpty()) {
		int currentSize=queue.size();
		for(int j=0;j<currentSize;j++) {
			List<Integer> currentList=queue.poll();
			int currentValue=input.get(currentLevel);
			//add current value in all the places of current list
			for(int i=0;i<=currentList.size();i++) {
				
				List<Integer> newList=new ArrayList<>(currentList);
				newList.add(i,currentValue);
				queue.add(newList);
			}
			
		}
		if(currentLevel==input.size()-1) {
			return queue;
		}else {
			currentLevel=currentLevel+1;
		}
	}
	return null;
}
}
