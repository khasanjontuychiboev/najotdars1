package dars.dars36;

enum PenStatus{
    FOR_THREAD_1,
    FOR_THREAD_2,
    FOR_THREAD_3
}
class Pen{
    String uzb;//hello
    String en;//salom


    int siyoh = 100;
    PenStatus penStatus = PenStatus.FOR_THREAD_1;


    public synchronized void forThread1(){
        while (siyoh>0){
            while (penStatus!=PenStatus.FOR_THREAD_1){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            siyoh = siyoh-10;
            System.out.println(Thread.currentThread().getName()+" pen used. ");
            penStatus=PenStatus.FOR_THREAD_2;
            notifyAll();
        }
    }

    public synchronized void forThread2(){
        while (siyoh>0){
            while (penStatus!=PenStatus.FOR_THREAD_2){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            siyoh = siyoh-10;
            System.out.println(Thread.currentThread().getName()+" pen used. ");
            penStatus=PenStatus.FOR_THREAD_3;
            notifyAll();
        }
    }


    public synchronized void forThread3(){
        while (siyoh>0){
            while (penStatus!=PenStatus.FOR_THREAD_3){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            siyoh = siyoh-10;
            System.out.println(Thread.currentThread().getName()+" pen used. ");
            penStatus=PenStatus.FOR_THREAD_1;
            notifyAll();
        }
    }
}
public class Thread3NotifyAll {

    public static void main(String[] args) {
        Pen obj = new Pen();

        Thread t1 = new Thread(()->{
            obj.forThread1();
        });

        Thread t2 = new Thread(()->{
            obj.forThread2();
        });

        Thread t3 = new Thread(()->{
            obj.forThread3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
