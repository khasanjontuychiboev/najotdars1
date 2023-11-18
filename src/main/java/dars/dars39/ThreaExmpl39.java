package dars.dars39;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ClassTask{
    public void addMaoney(){
        System.out.println(Thread.currentThread().getName()+" shu taskni bajrdi");
    }
}

public class ThreaExmpl39 {
    public static void main(String[] args) throws InterruptedException {
        ClassTask obj = new ClassTask();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<100; i++){
            executorService.submit(obj::addMaoney);
        }
        //Thread.sleep(2000);
        System.out.println("main");
        executorService.shutdown();
    }
}
