package demo.demo34;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int NUM_THREADS = 5;
    private static final int NUM_PERMITS = 2;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(NUM_PERMITS);

        for (int i = 1; i <= NUM_THREADS; i++) {
            Thread thread = new Thread(new Worker(semaphore, i));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;
        private final int id;

        public Worker(Semaphore semaphore, int id) {
            this.semaphore = semaphore;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + id + " is trying to acquire a permit.");
                semaphore.acquire();
                System.out.println("Thread " + id + " has acquired a permit.");

                // Simulating some work being done
                Thread.sleep(2000);

                System.out.println("Thread " + id + " is releasing the permit.");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}