package dars.dars38;

import java.util.concurrent.atomic.AtomicBoolean;

class ExampleAtomBool{
    public AtomicBoolean ozg = new AtomicBoolean();

}
public class ExampleForAtamicBoolean {
    public static void main(String[] args) {
        ExampleAtomBool obj = new ExampleAtomBool();

        Thread t1 = new Thread(()->{
            if (!obj.ozg.compareAndSet(false, true)){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" if shartiag kirdi");

            }else {
                System.out.println(Thread.currentThread().getName()+" els shartiag kirdi");

            }
        });
        Thread t2 = new Thread(()->{

            if (!obj.ozg.compareAndSet(false, true)){
                System.out.println(Thread.currentThread().getName()+" if shartiag kirdi");
            }else {
                System.out.println(Thread.currentThread().getName()+" els shartiag kirdi");

            }
        });
        t1.start();
        t2.start();

    }
}
