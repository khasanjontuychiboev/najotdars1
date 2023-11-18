package demo.demo33;

import java.util.ArrayList;
import java.util.List;

public class ArrayListThreadExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        int numThreads = 4;
        int elementsPerThread = 10;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new ListWriterService(list, i * elementsPerThread, elementsPerThread));
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the list contents
        System.out.println("List contents:");
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}

class ListWriter implements Runnable {
    private List<Integer> list;
    private int startIndex;
    private int numElements;

    public ListWriter(List<Integer> list, int startIndex, int numElements) {
        this.list = list;
        this.startIndex = startIndex;
        this.numElements = numElements;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < startIndex + numElements; i++) {
            synchronized (list) {
                list.add(i);
            }
        }
    }
}