package demo.demo34;

import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable{
    private CountDownLatch countDownLatch;

    public MyRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Job is done");
        countDownLatch.countDown();

    }
}
