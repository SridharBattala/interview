package com.sree.leave.programs.javaprogrames;
/**
 * need to findout the program
 * http://tutorials.jenkov.com/java-concurrency/volatile.html
 * https://www.javatpoint.com/volatile-keyword-in-java
 */
public class VolatileTest {
	static int  count=0;
	Thread trd1 = new Thread("My Thread 1") {
		public void run() {
			count=count+1;
		}
	};

	Thread trd2 = new Thread("My Thread 2") {
		public void run() {
			System.out.println(count);
		}
	};

	public static void main(String a[]) {
		VolatileTest test = new VolatileTest();
		test.trd1.start();
		test.trd2.start();
		System.out.println(test.count);
	}
}
