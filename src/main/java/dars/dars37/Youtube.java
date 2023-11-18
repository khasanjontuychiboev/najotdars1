package dars.dars37;

import java.util.concurrent.CountDownLatch;

class Video{
    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch2;

    public Video(CountDownLatch countDownLatch, CountDownLatch countDownLatch2) {
        this.countDownLatch = countDownLatch;
        this.countDownLatch2 = countDownLatch2;
    }

    public void watched(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("video korildi.");
        countDownLatch.countDown();
    }

    public void rek(){
        System.out.println("Video Rekka chiqdi!");
    }
}
public class Youtube {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        CountDownLatch latch2 = new CountDownLatch(100);
        Video video = new Video(latch, latch2);

        for (int i=0; i<100;i++){
            new Thread(video::watched).start();
        }

        System.out.println("kutb turibdi.....");
        latch.await();
        //...
        video.rek();
        ///.....

    }

}
