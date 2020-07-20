package com.sree.programs.important.javaseniorengineerquestions;

/**
 * https://www.java2novice.com/java-interview-programs/thread-deadlock/
 * 
 * @author sridharbattala
 *
 */
public class MyDeadlock {

	String str1 = "Java";
	String str2 = "UNIX";

	class Class1 implements Runnable {
		public void run() {
			while (true) {
				synchronized (str1) {
					synchronized (str2) {
						System.out.println(str1 + str2);
					}
				}
			}
		}
	}

	class Class2 implements Runnable {
		public void run() {
			while (true) {
				synchronized (str2) {
					synchronized (str1) {
						System.out.println(str2 + str1);
					}
				}
			}
		}
	}

	void createDeadLock() {
		Thread thread1 = new Thread(new Class1());
		Thread thread2 = new Thread(new Class2());
		thread1.start();
		thread2.start();
	}

	public static void main(String a[]) {
		MyDeadlock mdl = new MyDeadlock();
		mdl.createDeadLock();
	}
}
