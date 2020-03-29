package com.sree.programs.algorithms.dynamicprogramming;
/**
 * Abdul ravi for formula
 * https://www.youtube.com/watch?v=prx1psByp7U
 * 
 * https://www.youtube.com/watch?v=vgLJZMUfnsU&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=3
 * 
 * https://www.techiedelight.com/matrix-chain-multiplication/
 * 
 * https://www.youtube.com/watch?v=GMzVeWpyTN0&list=PLyEvk8ZeQDMVbsg7CEfT0NV3s3GkMx1vN&index=4
 */
class MatrixChainMultiplication
{
	// Function to find the most efficient way to multiply
	// given sequence of matrices
	public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                	System.out.println(i+", "+k+","+j);
                	System.out.println(temp[i][k] +", " +temp[k][j]+" ," +arr[i]+", "+arr[k]+","+arr[j]);
                	System.out.println("//n");
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        printTable(temp, arr.length, arr.length);
        return temp[0][arr.length-1];
    }
	static void printTable(int[][] dp, int rowsLength, int columnLength) {
		for (int i = 0; i < rowsLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
	}
    
	// main function
	public static void main(String[] args)
	{
		MatrixChainMultiplication mmc = new MatrixChainMultiplication();
        int arr[] = {2,3,6,4,5};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
	}
}
