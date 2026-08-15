package dev.selfdev;
import java.io.IOException;

public class ProcessLauncher {

    public static void main(String[] args) throws IOException {

        String javaHome = System.getProperty("java.home");

        String javaExecutable =
                javaHome + "/bin/java";

        String classPath =
                System.getProperty("java.class.path");

        Process p1 = new ProcessBuilder(
                javaExecutable,
                "-cp",
                classPath,
                "Worker",
                "Worker-1"
        ).inheritIO().start();

        Process p2 = new ProcessBuilder(
                javaExecutable,
                "-cp",
                classPath,
                "Worker",
                "Worker-2"
        ).inheritIO().start();

        Process p3 = new ProcessBuilder(
                javaExecutable,
                "-cp",
                classPath,
                "Worker",
                "Worker-3"
        ).inheritIO().start();

        System.out.println(
                "Started PIDs: "
                + p1.pid() + ", "
                + p2.pid() + ", "
                + p3.pid()
        );
    }
}