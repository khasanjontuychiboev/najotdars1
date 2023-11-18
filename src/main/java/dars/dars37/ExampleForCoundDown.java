package dars.dars37;

import java.util.concurrent.CountDownLatch;

class Example{
    private CountDownLatch countDownLatch;

    public Example(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void ixtioriy(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" counted.");
        countDownLatch.countDown();
    }

    public void chklash(){
        System.out.println("Bu user endi yoza olmedi..");
    }
}

public class ExampleForCoundDown {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Example obj = new Example(latch);

        for (int i=0; i<10; i++){
            new Thread(obj::ixtioriy).start();
        }

        latch.await();
        System.out.println("Main is woeking...");
        obj.chklash();
        //...
    }
}
