package dars.dars37.semfor;

import java.util.concurrent.Semaphore;

public class ExampleBank {
    private Semaphore semaphore;

    public ExampleBank(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void bankXimati(){
        System.out.println(Thread.currentThread().getName()+" navbat kutb turibdi");
        //...
        try {
            semaphore.acquire();//xizmat korsatilmoqda
            System.out.println(Thread.currentThread().getName()+" foydalnmoqda...");
            Thread.sleep(1000);

            //ximat real
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" foydalanib  boldi!");
        semaphore.release();

    }
}
