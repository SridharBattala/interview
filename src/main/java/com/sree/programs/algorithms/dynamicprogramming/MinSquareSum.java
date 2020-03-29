package com.sree.programs.algorithms.dynamicprogramming;
/*
 * https://www.youtube.com/watch?v=Y0ZqKpToTic&t=311s
 * image also attached
 */
public class MinSquareSum {
	

		public static void solve(int n) {
			int options = (int) Math.sqrt(n);
			//solve using Dynamic programming
			System.out.println("output="+solveUsingDP(n, options));
		}
		public static int solveUsingDP(int n, int options) {
			int[][] mainArr=new int[options][n+1];
			int[] numArr=new int[options];
			//create num array
			for(int i=0;i<options;i++) {
				numArr[i]=(i+1)*(i+1);
			}
			//create main array
			for(int i=0;i<options;i++) {
				for(int j=0;j<n+1;j++) {
					if(i==0) {
						mainArr[i][j]=j;
					}else if(j>=numArr[i]) {
						mainArr[i][j]=Math.min(mainArr[i-1][j], mainArr[i][j-numArr[i]]+1);
					}else {
						mainArr[i][j]=mainArr[i-1][j];
					}
						
					System.out.print(mainArr[i][j]+"    ");
					
				}
				System.out.println();
			}
			return mainArr[options-1][n];
		}

		public static void main(String[] args) {
			int N = 12;
			
			solve(N);
		}

	
}
