package com.sree.programs.important.javaseniorengineerquestions;

import java.util.*;
import java.util.concurrent.*;;

/*
 * http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html
 */
public class BlockingQueueProducerConsumer {

	public static void main(String[] args) throws Exception {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		Thread producerThread = new Thread(producer);
		producerThread.start();
		Thread.sleep(4000);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		// Thread.sleep(4000);
	}
}

class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(i + "");
				System.out.println("produced " + i);

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("consumedddddd " + queue.take());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
