package dars.dars39;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class WebS{
    private AtomicInteger soni = new AtomicInteger(0);
    public void login(){
        soni.incrementAndGet();
        System.out.println(Thread.currentThread().getName());
    }

    public void logout(){
        soni.decrementAndGet();
        System.out.println(Thread.currentThread().getName());
    }

    public AtomicInteger getSoni() {
        return soni;
    }
}
public class WebSahifa39 {
    public static void main(String[] args) throws InterruptedException {
        WebS obj = new WebS();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<1000;i++){
            executorService.submit(obj::login);
        }
        for (int i=0; i<50;i++){
            executorService.submit(obj::logout);
        }

        Thread.sleep(2000);
        System.out.println(obj.getSoni().get());
        executorService.shutdown();

    }
}
