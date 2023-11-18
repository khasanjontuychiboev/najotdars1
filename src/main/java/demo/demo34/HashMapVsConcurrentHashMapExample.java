package demo.demo34;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsConcurrentHashMapExample {
    private static final int NUM_THREADS = 4;
    private static final int NUM_OPERATIONS = 100000;

    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        System.out.println("Testing HashMap:");
        runThreadedOperations(hashMap);

        System.out.println("\nTesting ConcurrentHashMap:");
        runThreadedOperations(concurrentHashMap);
    }

    private static void runThreadedOperations(Map<Integer, Integer> map) {
        Thread[] threads = new Thread[NUM_THREADS];
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_OPERATIONS; j++) {
                    map.put(j, j);
                    map.remove(j);
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
        System.out.println("Size of the map: " + map.size());
        System.out.println("Total time taken: " + (endTime - startTime) + " milliseconds");
    }
}