package demo.demo34;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListVsCopyOnWriteArrayListExample {
    private static final int NUM_THREADS = 4;
    private static final int NUM_OPERATIONS = 100000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        System.out.println("Testing ArrayList:");
        runThreadedOperations(arrayList);

        System.out.println("\nTesting CopyOnWriteArrayList:");
        runThreadedOperations(copyOnWriteArrayList);
    }

    private static void runThreadedOperations(List<Integer> list) {
        Thread[] threads = new Thread[NUM_THREADS];
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_OPERATIONS; j++) {
                    list.add(j);
                    list.remove(0);
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Size of the list: " + list.size());
        System.out.println("Total time taken: " + (endTime - startTime) + " milliseconds");
    }
}