package demo.demo34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class StringBufferVsStringBuilderExample {
    public static void main(String[] args) {
        Vector<Integer> vectorNames = new Vector<>();
        CopyOnWriteArrayList<Integer> lisNames = new CopyOnWriteArrayList<>();

            Thread thread1 = new Thread(() -> {
                for (int i=0; i<20; i++){
                    vectorNames.add(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });


            Thread thread2 = new Thread(() -> {
                for (int i=0; i<20; i++){
                    lisNames.add(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread1.start();
            thread2.start();

        System.out.println("vector length: " + vectorNames);
        System.out.println("arrayList length: " + lisNames);
    }
}