package demo.demo37;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            ConcurrentHashMap<String, Integer> students = new ConcurrentHashMap<>();
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    String key = new Random().toString() + Thread.currentThread().getName();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    students.put(key, 25);
                }
            });

            Thread t2 = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    String key = new Random().toString() + Thread.currentThread().getName();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    students.put(key, 25);
                }
            });

            t.start();
            t2.start();

            t.join();
            t2.join();
            System.out.println(students.size());

        }

    }
}
