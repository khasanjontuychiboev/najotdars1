package demo.demo34;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        ShinaAlmashtirish shinaAlishtirishTask = new ShinaAlmashtirish(countDownLatch);
        new Thread(shinaAlishtirishTask).start();
        new Thread(shinaAlishtirishTask).start();
        new Thread(shinaAlishtirishTask).start();
        new Thread(shinaAlishtirishTask).start();
        new Thread(shinaAlishtirishTask).start();
        new Thread(shinaAlishtirishTask).start();
        countDownLatch.await();
        System.out.println("Main thread is done!");
    }
}
