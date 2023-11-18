package org.example;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassCounter cc = new ClassCounter();

        Thread t1 = new Thread(()->{
            for (int i=0; i < 10; i++){
                System.out.println("t1");
                cc.increaseLike(5);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i=0; i<10; i++){
                System.out.println("t2");
                cc.increaseLike(10);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Result "+cc.numberOfLike);
        System.out.println("Result "+cc.numberOfDislike);
    }
}