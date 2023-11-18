package demo.demo38;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(true);

        Runnable task = () -> {
            if (flag.compareAndSet(false, false)) {
                // Perform some critical section operations
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " + Thread.currentThread().getId() + " acquired the lock.");
                // ...
                System.out.println("Thread " + Thread.currentThread().getId() + " released the lock.");

            } else {
                System.out.println("Thread " + Thread.currentThread().getId() + " failed to acquire the lock.");
            }
        };

        // Create multiple threads to concurrently access the critical section
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}