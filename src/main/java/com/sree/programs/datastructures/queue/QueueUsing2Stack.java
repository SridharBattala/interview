package com.sree.programs.datastructures.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stack {
	  private static Stack<Integer> stack1=new Stack<>();
	  private static Stack<Integer> stack2=new Stack<>();
		public static void main (String[] args) {
			
	    
	    enqueue(1);
	    enqueue(2);
	    enqueue(3);
	    enqueue(4);
	    dequeue();
	    print();
		}
	  public static void enqueue(int value){
	    stack1.push(value);
	  }
	  
	  public static int dequeue(){
	    //if stack2 is empty
	    if(stack2.isEmpty()){
	      //add all ements to stack2
	      while(!stack1.isEmpty()){
	        stack2.push(stack1.pop());
	      }
	      
	    }
	    return stack2.pop();
	  }
	  public static int peek(){
	    //if stack2 is empty
	    if(stack2.isEmpty()){
	      //add all ements to stack2
	      while(!stack1.isEmpty()){
	        stack2.push(stack1.pop());
	      }
	      
	    }
	    return stack2.peek();
	  }
	  public static boolean empty(){
	    return stack1.isEmpty() && stack2.isEmpty() ;
	  }
	  public static void print(){
		  while(!stack1.isEmpty()){
		        stack2.push(stack1.pop());
		      }
		  for(int i=stack2.size()-1;i>=0;i--){
		        System.out.print(stack2.get(i)+"-->");
		      }
		  }
}
