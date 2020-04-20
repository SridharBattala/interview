package com.sree.programs.patterns.dpfibonaccinumbers;

public class NumberToOne {
public static void main(String[] args) {
	int minSteps=helper(11);
	System.out.println("minSteps="+minSteps);
}
public static int helper(int input){
	
	if(input==1) {
		return 1;
	}else if(input==2){
		return 1;
	}else if(input==3){
		return 1;
	}else {
		int step1=Integer.MAX_VALUE,step2=Integer.MAX_VALUE,step3=Integer.MAX_VALUE;
		if(input%3==0) {
			step1=1+helper( input/3);
		}
		if(input%2==0) {
			step2=1+helper( input/2);
		}
		step3=1+helper( input-1);
		return Math.min(Math.min(step1, step2),step3);
	}
}
}
