package demo.demo37;

import java.util.concurrent.CountDownLatch;

class DarsQoldirish{
    CountDownLatch countDownLatch;

    public DarsQoldirish(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void darsQoldirish(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dars qoldirildi.");
        countDownLatch.countDown();
    }
}

public class ExampleDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        DarsQoldirish darsQoldirish = new DarsQoldirish(latch);
        new Thread(darsQoldirish::darsQoldirish).start();
        new Thread(darsQoldirish::darsQoldirish).start();
        new Thread(darsQoldirish::darsQoldirish).start();
        new Thread(darsQoldirish::darsQoldirish).start();
        new Thread(darsQoldirish::darsQoldirish).start();

        latch.await();
        System.out.println("3 tadan ko'p dars qoldirildi!");

    }
}
