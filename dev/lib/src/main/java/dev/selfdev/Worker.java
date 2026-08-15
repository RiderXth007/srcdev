package dev.selfdev;

public class Worker {

    public static void main(String[] args) throws Exception {

        String workerName = args.length > 0
                ? args[0]
                : "Unknown";

        System.out.println(
            "Worker = " + workerName
            + ", PID = " + ProcessHandle.current().pid()
        );

        Thread.sleep(100000);
    }
}