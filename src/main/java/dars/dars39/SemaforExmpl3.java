package dars.dars39;

import java.util.concurrent.Semaphore;

class Kassa{
    private Semaphore semaphore;

    public Kassa(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void kassagKirim(){
        System.out.println(Thread.currentThread().getName()+" kassaga keldi kutmoqda");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"Jarayon");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " Kassaga kirim boldi");
        semaphore.release();
    }

}
public class SemaforExmpl3 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        Kassa kassa = new Kassa(semaphore);
        for (int i=0; i<100;i++){
            new Thread(kassa::kassagKirim).start();
        }

    }
}
