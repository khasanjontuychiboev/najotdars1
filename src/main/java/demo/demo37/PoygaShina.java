package demo.demo37;

import java.util.concurrent.CountDownLatch;

class Shina{
    CountDownLatch countDownLatch;

    public Shina(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void shinaAlmash(){
        if (countDownLatch.getCount()>0){
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount()+1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class PoygaShina {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        Shina shina = new Shina(latch);
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();
        new Thread(shina::shinaAlmash).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done!! Goo!!");
    }
}
