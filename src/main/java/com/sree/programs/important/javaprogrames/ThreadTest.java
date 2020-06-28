package com.sree.programs.important.javaprogrames;

public class ThreadTest {
	public static void main(String args[]) throws InterruptedException {
		Test1 test1 = new Test1();
		Thread thread = new Thread(test1);
		thread.setDaemon(true);
		thread.start();
		thread.join();
	}
}

class Test1 implements Runnable {
	public void run() {
		while (true) {
			System.out.println("enter");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}
}
