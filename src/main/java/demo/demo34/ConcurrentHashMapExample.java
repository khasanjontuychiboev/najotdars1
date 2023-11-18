package demo.demo34;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        System.out.println("Initial map: " + map);

        // Concurrent modification using multiple threads
        Thread thread1 = new Thread(() -> {
            map.put("Durian", 40);
            map.remove("Apple");
        });

        Thread thread2 = new Thread(() -> {
            map.put("Elderberry", 50);
            map.remove("Banana");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final map: " + map);
    }
}