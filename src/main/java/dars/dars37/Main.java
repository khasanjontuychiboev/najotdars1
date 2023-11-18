package dars.dars37;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        UzumMArket mArket = new UzumMArket(latch);
        for (int i=0;i<100;i++){
            new Thread(mArket::sotibOlindi).start();
        }


        latch.await();
        mArket.topMaxsulotlargaQoshildi();
    }
}
