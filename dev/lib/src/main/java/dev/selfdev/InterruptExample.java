package dev.selfdev;

public class InterruptExample implements Runnable {
	public void run() {
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("[" + Thread.currentThread().getName() + "] Interrupted by exception!");
		}
		while (!Thread.interrupted()) {
// do nothing here
		}
		System.out.println("[" + Thread.currentThread().getName() + "] Interrupted for the second time.");
	}

	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread(new InterruptExample(), "myThread");
		myThread.start();
		System.out.println("[" + Thread.currentThread().getName() + "] 1st Sleeping in main thread for 5s...");
		Thread.sleep(5000);
		System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread");
		myThread.interrupt();
		System.out.println("[" + Thread.currentThread().getName() + "] 2nd Sleeping in main thread for 5s...");
		Thread.sleep(5000);
		System.out.println("[" + Thread.currentThread().getName() + "] Interrupting myThread-2");
		myThread.interrupt();
	}
}