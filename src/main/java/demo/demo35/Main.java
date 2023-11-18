package demo.demo35;

import dars.dars35.News;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        News n = new News();
        Thread t1 = new Thread(()->{
            n.produce();
        }, "Producer");

        Thread t2 = new Thread(()->{
            n.reader();
        }, "Reader1");

        Thread t3 = new Thread(()->{
            n.reader();
        }, "Reader2");


        t1.start();
        t2.start();
        t3.start();


        t1.join();
        t2.join();
        t3.join();
    }
}
