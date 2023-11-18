package demo.demo37;

import java.util.concurrent.Semaphore;

class BankXizmati {
    private Semaphore semaphore;

    public BankXizmati(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void xizmatKorsatish() {
        try {
            System.out.println(Thread.currentThread().getName() + " xizmat uchun navbatga keldi");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " uchun xizmat ko'rsatilmoqda...");
            Thread.sleep(200);

            System.out.println(Thread.currentThread().getName() + " uchun xizmat ko'rsatib bo'lindi navbat bo'shadi!");
            semaphore.release();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

public class SemaphoreExample {
    public static void main(String[] args){
        Semaphore s = new Semaphore(3);
        BankXizmati bankXizmati = new BankXizmati(s);

        for (int i=0; i<10; i++){
            new Thread(bankXizmati::xizmatKorsatish).start();
        }
    }
}
