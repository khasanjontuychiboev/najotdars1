package dars.dars34;

public class ImmutableStringExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i=1; i<=100;i++){

            StringBuffer str = new StringBuffer();
            Thread t1 = new Thread(()->{
                str.append(Thread.currentThread().getName().toLowerCase())
                        .append(Thread.currentThread().getName().toLowerCase())
                        .append(Thread.currentThread().getName().toLowerCase())
                        .append(Thread.currentThread().getName().toLowerCase());
            }, "l");

            Thread t2 = new Thread(()->{
                str.append(Thread.currentThread().getName().toUpperCase())
                        .append(Thread.currentThread().getName().toUpperCase())
                        .append(Thread.currentThread().getName().toUpperCase())
                        .append(Thread.currentThread().getName().toUpperCase());
            },"M");

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            System.out.println(str);
        }
    }
}
