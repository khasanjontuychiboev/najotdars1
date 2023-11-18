package demo.demo38;

import java.util.concurrent.atomic.AtomicInteger;

class Example{
    private volatile int count=0;
    public void increment(){
        for (int i=0; i<5;i++){
            try {
                Thread.sleep(i*10);
                count++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void showCount(){
        System.out.println(count);
    }
}
public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<10;i++){
            Example obj = new Example();
            Thread t1 = new Thread(obj::increment);
            Thread t2 = new Thread(obj::increment);
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            obj.showCount();
        }

    }
}
