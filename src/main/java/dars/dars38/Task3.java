package dars.dars38;

import java.util.concurrent.atomic.AtomicInteger;

class Maxsulot3{
    private AtomicInteger soni= new AtomicInteger(1000);

    public void sotibOlish(int x){
        soni.updateAndGet(v->v-x);
    }

    public AtomicInteger getSoni() {
        return soni;
    }
}
public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        Maxsulot3 obj = new Maxsulot3();

        for (int i=0; i<10; i++){
            new Thread(()->{
                obj.sotibOlish(5);
            }).start();

            new Thread(()->{
                obj.sotibOlish(5);
            }).start();
        }

        Thread.sleep(5000);
        System.out.println(obj.getSoni().get());
    }
}
