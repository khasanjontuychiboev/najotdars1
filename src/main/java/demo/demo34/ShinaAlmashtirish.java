package demo.demo34;

import java.util.concurrent.CountDownLatch;

public class ShinaAlmashtirish implements Runnable{
    private CountDownLatch countDownLatch;
    public ShinaAlmashtirish(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Shina almashtirildi");
        countDownLatch.countDown();
    }
}
