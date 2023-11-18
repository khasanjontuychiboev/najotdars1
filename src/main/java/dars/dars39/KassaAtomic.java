package dars.dars39;

import java.util.concurrent.atomic.AtomicReference;

class KssaPul{
    private AtomicReference<Double> amount = new AtomicReference<>(0D);

    public void addMoney(Double d){
        amount.updateAndGet(v->v+d);
    }


    public void removeMoney(Double d){
        amount.updateAndGet(v->v-d);
    }

    public AtomicReference<Double> getAmount() {
        return amount;
    }
}
public class KassaAtomic {
    public static void main(String[] args) throws InterruptedException {
        KssaPul obj = new KssaPul();
        for (int i=0; i<100; i++){
            new Thread(()->{
                obj.addMoney(50D);
            }).start();
            new Thread(()->{
                obj.removeMoney(20D);
            }).start();
        }

        Thread.sleep(3000);
        System.out.println(obj.getAmount().get());
    }
}
