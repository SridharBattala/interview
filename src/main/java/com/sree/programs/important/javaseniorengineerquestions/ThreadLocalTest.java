package com.sree.programs.important.javaseniorengineerquestions;

public class ThreadLocalTest {
	public static void main(String[] args) {
		TestClass testClass = new TestClass();
		Thread thread1 = new Thread(testClass);
		thread1.start();
		// System.out.println(testClass.count);
		System.out.println(testClass.counter.get());
		Thread thread2 = new Thread(testClass);
		thread2.start();
		// System.out.println(testClass.count);
		System.out.println(testClass.counter.get());
	}
}

class TestClass implements Runnable {
	// public int count = 0;
	ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 1);

	public void run() {
		// count = count + 1;
		counter.set(counter.get() + 1);
	}
}