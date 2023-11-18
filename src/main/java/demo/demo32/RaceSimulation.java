package demo.demo32;

import java.util.Random;

public class RaceSimulation {
    private static volatile int count = 0;
    private static final int NUM_ITERATIONS = 10;

    public static void main(String[] args) {
        Thread runner1 = new Thread(() -> {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                int increment = new Random().nextInt(5) + 1;
                incrementCount(increment);
                System.out.println("Runner 1: Count = " + count);
            }
        });

        Thread runner2 = new Thread(() -> {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                int increment = new Random().nextInt(5) + 1;
                incrementCount(increment);
                System.out.println("Runner 2: Count = " + count);
            }
        });

        runner1.start();
        runner2.start();

        try {
            runner1.join();
            runner2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Race completed.");
    }

    private static synchronized void incrementCount(int increment) {
        count += increment;
    }
}