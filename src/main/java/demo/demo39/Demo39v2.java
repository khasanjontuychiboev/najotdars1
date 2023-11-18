package demo.demo39;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo39v2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i=0; i<100; i++){
            executor.submit(()->{
                System.out.println("saytga "+ new Random() +" kirdi, vaqti " + LocalDateTime.now());
            });
        }
        executor.shutdown();
    }
}
