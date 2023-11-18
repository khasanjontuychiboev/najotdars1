package dars.dars32;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String k = "Tez aytish";
       Thread t1 = new Thread(()->{
           int count = 0;
           for(int i=0;i<100;i++){
               count++;
               try {
                   Thread.sleep(Math.abs(new Random().nextInt()%100));
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println(Thread.currentThread().getName()+" : "+k+ " "+ count);

           }
       },"1-ishtirokchi");

        Thread t2 = new Thread(()->{
            int count = 0;
            for(int i=0;i<100;i++){
                count++;
                try {
                    Thread.sleep(Math.abs(new Random().nextInt()%100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" : "+k+ " "+ count);

            }

        },"2-ishtirokchi");

        t1.start();
        t2.start();
        Thread.sleep(Math.abs(new Random().nextInt()%1000));


        System.out.println("O'yin tugadi!");

    }
}
