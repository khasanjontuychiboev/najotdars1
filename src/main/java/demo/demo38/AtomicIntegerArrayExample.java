package demo.demo38;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(array);

        // Increment a value at a specific index and get the updated value atomically
        int index = 2;
        int incrementedValue = atomicArray.incrementAndGet(index);
        System.out.println("Incremented value at index " + index + ": " + incrementedValue);

        // Add a value at a specific index and get the updated value atomically
        int valueToAdd = 10;
        int newValue = atomicArray.addAndGet(index, valueToAdd);
        System.out.println("New value at index " + index + " after addition: " + newValue);

        // Get the current value at a specific index
        int currentValue = atomicArray.get(index);
        System.out.println("Current value at index " + index + ": " + currentValue);

        // Compare and set the value at a specific index atomically
        int expectedValue = 14;
        int updatedValue = 20;
        boolean exchanged = atomicArray.compareAndSet(index, expectedValue, updatedValue);
        System.out.println("Value exchanged at index " + index + ": " + exchanged);
        System.out.println("Current value at index " + index + ": " + atomicArray.get(index));
    }
}