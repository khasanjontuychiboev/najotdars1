package dars.dars39;

import java.util.concurrent.CountDownLatch;

class Maxsulot{
    private CountDownLatch coundDownLatch;

    public Maxsulot(CountDownLatch coundDownLatch) {
        this.coundDownLatch = coundDownLatch;
    }

    public void sotibOlish(){
        System.out.println("sotib olindi");
        coundDownLatch.countDown();
    }
    public void top(){
        System.out.println("Top maxsulotlar qatoriga qo'shildi!");
    }
}
public class CoundDownLatchExmpl {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        Maxsulot m = new Maxsulot(latch);

        for (int i=0; i<100;i++){
            new Thread(m::sotibOlish).start();
        }

        latch.await();
        m.top();

    }
}
