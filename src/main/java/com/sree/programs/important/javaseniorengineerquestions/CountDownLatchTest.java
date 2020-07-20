package com.sree.programs.important.javaseniorengineerquestions;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		Worker worker1 = new Worker(countDownLatch, "worker1");

		Worker worker2 = new Worker(countDownLatch, "worker2");
		worker1.start();
		worker2.start();

		countDownLatch.await();

		Master master1 = new Master("master1");
		master1.start();
	}

}

class Worker extends Thread {
	private CountDownLatch countDownLatch;

	public Worker(CountDownLatch latch, String name) {
		super(name);
		this.countDownLatch = latch;
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " ended");
		countDownLatch.countDown();
	}
}

class Master extends Thread {

	public Master(String name) {
		super(name);

	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " started");

		System.out.println("Thread " + Thread.currentThread().getName() + " ended");

	}
}