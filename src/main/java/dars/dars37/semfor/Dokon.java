package dars.dars37.semfor;

import java.util.concurrent.Semaphore;

class Cassa{
    private Semaphore semaphore;

    public Cassa(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void ishJarayoni() {
        System.out.println(Thread.currentThread().getName()+" navbatga keldi...");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" ga xizmat korsatilmoqda..");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" chqib ketdi!");
        semaphore.release();
    }
}

public class Dokon {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        Cassa kassa = new Cassa(semaphore);

        for (int i=0; i<15;i++){
            new Thread(kassa::ishJarayoni).start();
        }

    }
}
