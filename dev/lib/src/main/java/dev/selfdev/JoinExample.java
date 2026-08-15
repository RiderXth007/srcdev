package dev.selfdev;

import java.util.Random;

public class JoinExample implements Runnable {
	private Random rand = new Random(System.currentTimeMillis());

	public void run() {
//simulate some CPU expensive task
		for (int i = 0; i < 100000000; i++) {
			rand.nextInt();
		}
		System.out.println("[" + Thread.currentThread().getName() + "] finished.");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new JoinExample(), "joinThread-" + i);
			System.out.println("Thread no. " + i + " " + threads[i].getStackTrace());
			System.out.println("Thread no. " + i + " Id # " + threads[i].getId() + " " +threads[i].toString());
			System.out.println("Thread no. " + i + " Id # " + threads[i].threadId() + " " +threads[i].toString());
			threads[i].start();
			threads[i].dumpStack();
			System.out.println("Thread no. " + i + " Started");
		}
		for (int i = 1; i < threads.length; i++) {
			threads[i].join();
		}
		System.out.println("[" + Thread.currentThread().getName() + "] All threads have finished.");
	}
}