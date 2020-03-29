package com.sree.leave.programs.javaprogrames;

public class Test {
	String str1="sridhar";
	String str2="pravali";
Thread t1=new Thread() {
	public void run() {
		while(true) {
		synchronized (str1) {
			synchronized (str2) {
				System.out.println(str1+str2);
			}
		}}
	}
};
Thread t2=new Thread() {
	public void run() {
		while(true) {
		synchronized (str2) {
			synchronized (str1) {
				System.out.println(str2+str1);
			}
		}
	}}
};
public static void main(String[] args) {
	Test test=new Test();
	test.t1.start();
	test.t2.start();
}
}
