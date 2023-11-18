package dars.dars37;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<10;i++){

            ConcurrentHashMap<String, Integer> students = new ConcurrentHashMap<>();

            Thread t1 = new Thread(()->{
                for (int j=0; j<100; j++){
                    students.put(new Random().toString(),10);
                }
            });


            Thread t2 = new Thread(()->{
                for (int j=0; j<100; j++){
                    students.put(new Random().toString(),10);
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            System.out.println(students.size());
        }

    }
}
