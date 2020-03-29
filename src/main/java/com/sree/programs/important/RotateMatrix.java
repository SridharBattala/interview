package com.sree.leave.programs.important;
/**
 * https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
 * @author sridharbattala
 *
 */
public class RotateMatrix {
	public static void main(String args[]) {
		int[][] arr = new int[4][4];
		int n = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = n++;
			}
		}
		printArr(arr);
		// transpose
		int temp;
		for (int i = 0; i < 4; i++) {
			for (int j = i; j < 4; j++) {
				temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
		printArr(arr);
		//reverse columns
		for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0, k = arr[0].length - 1; 
                 j < k; j++, k--) { 
                 temp = arr[j][i]; 
                arr[j][i] = arr[k][i]; 
                arr[k][i] = temp; 
            } 
		}
		
		printArr(arr);
	}
	static void swap() {
		
	}
	static void printArr(int[][] arr) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + "        ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
