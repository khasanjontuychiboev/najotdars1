package dars.dars38;

import java.util.concurrent.atomic.AtomicInteger;

class Class38{
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        for (int i=0;i<1000; i++){
            count.incrementAndGet();
        }
    }

    public int getCount(){
        return count.get();
    }
}
public class Example38 {
    public static void main(String[] args) {

        for (int i=0; i<10; i++){
            Class38 obj  = new Class38();

            Thread t1 = new Thread(()->{
                obj.increment();
            });
            Thread t2 = new Thread(()->{
                obj.increment();
            });
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(obj.getCount());
        }
    }

}
