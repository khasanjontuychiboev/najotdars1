package demo.demo34;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                list.add(i);
                System.out.println("Writer thread added: " + i);
                sleep(500); // Simulating some work
            }
        });

        Thread readerThread = new Thread(() -> {
            sleep(1000); // Wait for writerThread to add some elements
            for (Integer number : list) {
                System.out.println("Reader thread read: " + number);
                sleep(500); // Simulating some work
            }
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}