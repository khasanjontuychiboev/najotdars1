package demo.demo34;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        // Create a cached thread pool
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit tasks for execution
        for (int i = 0; i < 10; i++) {
            Runnable task = new Task("Task " + (i + 1));
            executor.submit(task);
        }

        // Shutdown the thread pool
        executor.shutdown();
    }

    static class Task implements Runnable {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing " + name + " on thread " + Thread.currentThread().getName());
            // Perform the task logic here
        }
    }
}