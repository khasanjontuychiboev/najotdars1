package dars.dars39;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class PlasticCard39v2{
    private AtomicReference<Double> money=new AtomicReference<>(0D);
    public void addMoney(Double d){
        money.updateAndGet(v->v+d);
    }
    public void spendMoney(Double d){
        money.updateAndGet(v->v-d);
    }

    public AtomicReference<Double> getMoney() {
        return money;
    }
}
public class Topshriq1D39 {
    public static void main(String[] args) throws InterruptedException {
        PlasticCard39v2 obj = new PlasticCard39v2();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0; i<100; i++){
            executorService.submit(()->{
                obj.addMoney(10D);
            });
            executorService.submit(()->{
                obj.spendMoney(5D);
            });
        }


        System.out.println(obj.getMoney().get());

    }
}
