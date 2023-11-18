package demo.demo37;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyonArrayListExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++){
            List<String> names = new CopyOnWriteArrayList<>();

            Thread t1 =new Thread(()->{
                for (int j=0; j<100; j++){
                    names.add(Thread.currentThread().getName());
                }
            });
            Thread t2 =new Thread(()->{
                for (int j=0; j<100; j++){
                    names.add(Thread.currentThread().getName());
                }
            });
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println(names.size());
        }
    }
}
