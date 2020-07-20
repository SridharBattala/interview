package com.sree.programs.important.javaseniorengineerquestions;

public class ThreadJoinExampleTest {
	public static void main(String args[]) throws InterruptedException {
		Test1 test1 = new Test1();
		Thread thread = new Thread(test1);
		thread.setDaemon(true);
		thread.start();
		// thread.join();
	}
}

class Test1 implements Runnable {
	public void run() {
		int i = 0;
		while (i < 5) {
			System.out.println("enter");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
			System.out.println("exit");
			i++;
		}
	}
}
