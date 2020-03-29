package com.sree.programs.algorithms.dynamicprogramming.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * @author sridharbattala
 *
 */
public class LongestCommonSubsequence {
	/* A Naive recursive implementation of LCS problem in java*/
	

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static List<String> lcs( char[] X, char[] Y, int m, int n,List<String> list ) 
	{ 
		System.out.println("x="+Arrays.toString(X)+", y="+Arrays.toString(Y)+",m="+m+",n="+n+"list="+list.toString());
		if (m == X.length || n == Y.length) {
			return list; 
		}
		if (X[m] == Y[n]) {
			List<String> list1=new ArrayList<String>(list); 
			list1.add(""+X[m]);
			return lcs(X, Y, m+1, n+1,list1); 
		}else
		{
			return max(lcs(X, Y, m, n+1,list), lcs(X, Y, m+1, n,list)); 

		}
		
		
	} 

	/* Utility function to get max of 2 Strings */
	static List<String> max(List<String> list1, List<String> list2) 
	{ 
		return (list1.size() > list2.size())? list1 : list2; 
	} 

	public static void main(String[] args) 
	{ 
	
		String s1 = "ATBC"; 
		String s2 = "GAYB"; 

		char[] X=s1.toCharArray(); 
		char[] Y=s2.toCharArray(); 
		

		System.out.println("Length of LCS is" + " " + 
									lcs( X, Y, 0, 0,new ArrayList<>() ) ); 
	} 

	} 

	


