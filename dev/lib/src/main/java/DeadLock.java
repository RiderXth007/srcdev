import java.util.Random;

public class DeadLock implements Runnable {
	private static final Object resource1 = new Object();
	private static final Object resource2 = new Object();
	private final Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {
		Thread myThread1 = new Thread(new DeadLock(), "thread-1");
		Thread myThread2 = new Thread(new DeadLock(), "thread-2");
		myThread1.start();
		myThread2.start();
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			boolean b = random.nextBoolean();
			System.out.println("[ Active-Thread -> " + Thread.currentThread().getName() + "]");
			System.out.println(Thread.currentThread().getName() + " [ resource1 lock status = " + Thread.holdsLock(resource1) + "]");
			System.out.println(Thread.currentThread().getName() + " [ resource2 lock status = " + Thread.holdsLock(resource2) + "]");
			
			if (b) {
				System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
				synchronized (resource1) {

					System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
					System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
					synchronized (resource2) {
						System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
					}
				}
			} else {
				System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
				synchronized (resource2) {
					System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
					System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
					synchronized (resource1) {
						System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
					}
				}
			}
		}
	}
}