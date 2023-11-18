package dars.dars37;

import java.util.concurrent.CountDownLatch;

public class Car {
    private CountDownLatch countDownLatch;

    public Car(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void balonAlmashtirish(){
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Balon alishtrildi.");
        countDownLatch.countDown();
        //...
    }

    public void yurmoq(){
        System.out.println("Avtomobile harkatlanishni bsoshladi...");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        Car obj = new Car(latch);
        for (int i=0; i<10; i++){
            new Thread(obj::balonAlmashtirish).start();
        }

        System.out.println("kutub turmoqda..");
        latch.await();
        System.out.println("Main thread davom etdi....");
        obj.yurmoq();
    }
}
