package demo.demo37;

import java.util.concurrent.CountDownLatch;

class Video{
    private CountDownLatch countDownLatch;
    private long korishlarSoni = 0;


    public Video(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    public synchronized void korildi(){
        System.out.println("ko'rildi");
        countDownLatch.countDown();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void recomendation(){
        System.out.println("Recomendation darajaga chiqdi!");
    }
}
public class YoutubaExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        Video video = new Video(latch);
        for (int i=0;i<100; i++){
            new Thread(video::korildi).start();
        }
        latch.await();
        video.recomendation();

    }
}
