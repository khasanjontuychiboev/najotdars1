package demo.demo38;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicDoubleExample {
    public static void main(String[] args) {
        AtomicReference<Double> atomicDouble = new AtomicReference<>(0.0);
        double incrementedValue = atomicDouble.updateAndGet(value -> value + 1.0);
        System.out.println("Incremented value: " + incrementedValue);
        double valueToAdd = 5.0;
        double newValue = atomicDouble.updateAndGet(value -> value + valueToAdd);
        System.out.println("New value after addition: " + newValue);
        double currentValue = atomicDouble.get();
        System.out.println("Current value: " + currentValue);
        double updatedValue = 10.0;
        atomicDouble.set(updatedValue);
        System.out.println("Updated value: " + atomicDouble.get());
    }
}