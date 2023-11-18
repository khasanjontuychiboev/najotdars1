package dars.dars38;

class Ruchka5{
    private int mg = 10;
    private StatusRuchka status = StatusRuchka.BIRINCHI;

    public synchronized void birinchi(){
        while (mg>0){
            while (!status.equals(StatusRuchka.BIRINCHI)){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mg--;
            System.out.println(Thread.currentThread().getName()+ " foydalandi.");
            status = StatusRuchka.IKKINCHI;
            notifyAll();
        }

    }

    public synchronized void ikkinchi(){
        while (mg>0) {
            while (!status.equals(StatusRuchka.IKKINCHI)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mg--;
            System.out.println(Thread.currentThread().getName() + " foydalandi.");
            status = StatusRuchka.UCHINCHI;
            notifyAll();
        }
    }


    public synchronized void uchinchi(){
        while (mg>0) {
            while (!status.equals(StatusRuchka.UCHINCHI)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mg--;
            System.out.println(Thread.currentThread().getName() + " foydalandi.");
            status = StatusRuchka.BIRINCHI;
            notifyAll();
        }
    }

    public int getMg() {
        return mg;
    }

    public void setMg(int mg) {
        this.mg = mg;
    }
}

enum StatusRuchka{
    BIRINCHI,
    IKKINCHI,
    UCHINCHI
}
public class Task5 {
    public static void main(String[] args) {
        Ruchka5 obj = new Ruchka5();
        new Thread(obj::birinchi).start();
        new Thread(obj::ikkinchi).start();
        new Thread(obj::uchinchi).start();


    }

}
