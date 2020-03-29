package com.sree.leave.programs.datastructures.arrays;

import java.util.List;

/**
You are given an array of integers and an integer. 
Write a function that moves all instances of that integer in the array to the end of the array. 
The function should perform this in place and does not need to maintain the order of the other integers.

Sample input: [2, 1, 2, 2, 2, 3, 4, 2], 2
Sample output: [1, 3, 4, 2, 2, 2, 2, 2] (the numbers 1, 3, and 4 could be ordered differently)

​import java.util.*;
*/
class Program {
  // O(n) time | O(1) space - where n is the length of the array
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int i = 0;
    int j = array.size() - 1;
    while (i < j) {
      while (i < j && array.get(j) == toMove) j--;
      if (array.get(i) == toMove) swap(i, j, array);
      i++;
    }
    return array;
  }

  public static void swap(int i, int j, List<Integer> array) {
    int temp = array.get(j);
    array.set(j, array.get(i));
    array.set(i, temp);
  }
}


