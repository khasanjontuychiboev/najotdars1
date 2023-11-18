package dars.dars33;

import java.util.concurrent.atomic.AtomicInteger;

public class TetsDars {
    static AtomicInteger counter = new AtomicInteger();
//    static volatile int counter;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++){
            counter.set(0);
//            counter=0;
            Thread t1 = new Thread(()->{
                System.out.println("Thread "+ Thread.currentThread().getName());
                for (int j=0; j<1000; j++){
                    counter.incrementAndGet();
//                    counter++;
                }
            });

            Thread t2 = new Thread(()->{
                for (int j=0; j<1000; j++){
                    counter.incrementAndGet();
//                    counter++;
                }
                System.out.println("Thread "+ Thread.currentThread().getName());

            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println( counter);


        }
    }
}
