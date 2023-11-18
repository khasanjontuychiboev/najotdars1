package demo.demo38;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Increment and get the updated value atomically
        int incrementedValue = atomicInt.incrementAndGet();
        System.out.println("Incremented value: " + incrementedValue);

        // Decrement and get the updated value atomically
        int decrementedValue = atomicInt.decrementAndGet();
        System.out.println("Decremented value: " + decrementedValue);

        // Add a value and get the updated value atomically
        int newValue = atomicInt.addAndGet(5);
        System.out.println("New value after addition: " + newValue);

        // Compare and set the value atomically
        boolean exchanged = atomicInt.compareAndSet(5, 10);
        System.out.println("Value exchanged: " + exchanged);
        System.out.println("Current value: " + atomicInt.get());
    }
}