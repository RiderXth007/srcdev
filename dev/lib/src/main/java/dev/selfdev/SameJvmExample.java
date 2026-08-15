package dev.selfdev;

public class SameJvmExample {

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            System.out.println(
                "Thread = " + Thread.currentThread().getName()
            );

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");
        Thread t3 = new Thread(task, "Worker-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}