package com.sree.programs.datastructures.graph;

import java.util.*;
public class GraphPrintAllPathsMatrix {
	static int source=0;
	static int destination=3;
	static int[][] input= { {0,1,1,0},
							{0,0,0,1},
							{0,0,0,1},
							{0,0,0,0}};
	static List<Integer> currentStackPath=new ArrayList<>();
	static List<List<Integer>> output=new ArrayList<>();
	static Set<Integer> visitedSet=new HashSet<>();
	public static void main(String[] args) {

		printPaths(source);
		for(List<Integer> path:output) {
			for(Integer value:path) {
				System.out.print(value+"-->");
			}
			System.out.println();
		}
	}
	public static void printPaths(int currentSource) {
		
			visitedSet.add(currentSource);
			currentStackPath.add(currentSource);
			//base case
			if(currentSource==destination) {
				output.add(new ArrayList<Integer>(currentStackPath));
				
			}
			//recursive case
			else {
				//loop current vertex neighbors
				for(int j=0;j<input[0].length;j++) {
					if(!visitedSet.contains(j) && input[currentSource][j]==1) {
						
						printPaths(j);
					}
				}
			}
			visitedSet.remove(currentSource);
			currentStackPath.remove(currentStackPath.size()-1);
			
	}
	public static void helper(int[][] input,int source,int destination,List<List<Integer>> output,List<Integer> currentStackPath){
		
	}
}




