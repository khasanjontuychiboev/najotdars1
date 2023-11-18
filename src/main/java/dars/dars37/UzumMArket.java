package dars.dars37;

import java.util.concurrent.CountDownLatch;

public class UzumMArket {
    private CountDownLatch countDownLatch;

    public UzumMArket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void sotibOlindi(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("SotibOlindi");
        countDownLatch.countDown();//9,8,7...0
    }

    public void topMaxsulotlargaQoshildi(){
        System.out.println("Top maxsulotlarga qo'shildi!");
    }
}
