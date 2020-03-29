package com.sree.leave.programs.datastructures.arrays;
/**
 * check for below vedio instead of AE
 * https://www.youtube.com/watch?v=Hg03KTli9co
 */
import java.util.Arrays;


public class SubarraySortAE {

   public static void main(String[] args) {
       int[] array1 = {1, 4, 7, 3, 10, 48, 17, 26, 30, 45, 50, 62};
       printMaxLengthSubarray(array1);

       int[] array2 = {1, 2, 3, 4, 5};
       printMaxLengthSubarray(array2);
        
       int[] array3 = {5, 4, 3, 2, 1};
       printMaxLengthSubarray(array3);
       
       int[] array4 = {1,2,4,7,10,11,7,12,6,7,16,18,19};
       printMaxLengthSubarray(array4);
   }
    
   public static void printMaxLengthSubarray(int[] array) {
        
       int n = array.length;

       // From the beginning of the array, move to element in the array up to which the elements are sorted i.e. where array[i] > array[i+1]. Set startIndex = i.
       int startIndex = 0;
       for (int i = 0; i < n-1; i++) {
           if(array[i] > array[i+1]) {
               startIndex = i;
               break;
           }
       }

       // From the end of the array, move to the element up to which the elements are sorted in reverse order i.e. where array[j-1] > array[j]. Set endIndex = j.
       int endIndex = 0;
       for (int j = n-1; j > 0; j--) {
           if(array[j-1] > array[j]) {
               endIndex = j;
               break;
           }
       }

       // Find the minimum and maximum element in the sub array from startIndex to endIndex.
       int maxElement = array[startIndex];
       int minElement = array[startIndex];
       for (int i = startIndex+1; i <= endIndex; i++) {
           if(maxElement < array[i]) {
               maxElement = array[i];
           }
           if(minElement > array[i]) {
               minElement = array[i];
           }
       }
        
       // Search the sorted array from 0 to startIndex to find the index at which minimum element will be in sorted array say, minIndex.
       int minIndex = findMinIndex(array, minElement, startIndex);
        
       // Search the sorted array from endIndex to end of array to find the index at which maximum element will be in sorted array say, maxIndex.
       int maxIndex = findMaxIndex(array, maxElement, endIndex);
       System.out.println("minIndex="+minIndex+",maxIndex="+maxIndex);
       // Sub array between minIndex to maxIndex is the required sub array.
       if(minIndex == maxIndex) {
           System.out.println("The array is already sorted.");
           return;
       }
       for (int i = minIndex; i <= maxIndex; i++) {
           System.out.print(array[i] + " ");
       }
       System.out.println();
   }

   private static int findMinIndex(int[] array, int minElement, int startIndex) {
       for(int i = 0; i < startIndex; i++) {
           if(minElement < array[i]) {
               return i;
           }
       }
       return startIndex;
   }
    
   private static int findMaxIndex(int[] array, int maxElement, int endIndex) {
       for(int i = array.length-1; i > endIndex; i--) {
           if(maxElement > array[i]) {
               return i;
           }
       }
       return endIndex;
   }

}

