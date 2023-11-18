package dars.dars38;

import java.util.concurrent.atomic.AtomicReference;

class Plastik4{
    private AtomicReference<Double> amount = new AtomicReference<>(0.0D);

    public void addValue(Double d){
        amount.updateAndGet(v -> v+d);
    }


    public void descreaseValue(Double d){
        amount.updateAndGet(v -> v-d);
    }

    public AtomicReference<Double> getAmount() {
        return amount;
    }
}
public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        Plastik4 obj = new Plastik4();

        for (int i=0; i<100;i++){
            new Thread(()->{
                obj.addValue(20D);
            }).start();

            new Thread(()->{
                obj.descreaseValue(10D);
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(obj.getAmount().get());
    }
}
