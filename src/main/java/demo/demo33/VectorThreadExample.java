package demo.demo33;

import java.util.Vector;

public class VectorThreadExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        int numThreads = 4;
        int elementsPerThread = 10;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new VectorWriter(vector, i * elementsPerThread, elementsPerThread));
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

        // Print the vector contents
        System.out.println("Vector contents:");
        synchronized (vector) {
            for (int i = 0; i < vector.size(); i++) {
                System.out.println(vector.get(i));
            }
        }
    }
}

class VectorWriter implements Runnable {
    private Vector<Integer> vector;
    private int startIndex;
    private int numElements;

    public VectorWriter(Vector<Integer> vector, int startIndex, int numElements) {
        this.vector = vector;
        this.startIndex = startIndex;
        this.numElements = numElements;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < startIndex + numElements; i++) {
            synchronized (vector) {
                vector.add(i);
            }
        }
    }
}