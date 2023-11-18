package demo.demo38;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicPlastik {
    private AtomicReference<Double> amount = new AtomicReference<>(1000D);

    public Double getAmount(){
        return amount.get();
    }
    public void increase(Double x){
        amount.set(amount.get()+x);
    }


    public void decrease(Double x){
        amount.set(amount.get()-x);
    }

    public static void main(String[] args) {
        AtomicPlastik atomicPlastik = new AtomicPlastik();
        for (int i=0; i<10;i++){
            Thread t1 = new Thread(()->{
                for (int j=0; j<10;j++){
                    atomicPlastik.increase(10D);
                }
            });
            Thread t2 = new Thread(()->{
                for (int j=0; j<10;j++){
                    atomicPlastik.decrease(5D);
                }
            });

            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(atomicPlastik.getAmount());
        }
    }
}
