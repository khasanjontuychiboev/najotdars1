package demo.demo33;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorArrayListThreadExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        int numThreads = 4;
        int elementsPerThread = 10;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new ListWriterService(vector, i * elementsPerThread, elementsPerThread));
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

        System.out.println("Vector contents:");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new ListWriterService(arrayList, i * elementsPerThread, elementsPerThread));
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

        System.out.println("ArrayList contents:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

class ListWriterService implements Runnable {
    private List<Integer> list;
    private int startIndex;
    private int numElements;

    public ListWriterService(List<Integer> list, int startIndex, int numElements) {
        this.list = list;
        this.startIndex = startIndex;
        this.numElements = numElements;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < startIndex + numElements; i++) {
            list.add(i);
        }
    }
}