package demo.demo38;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicEmployeeExample {
    public static void main(String[] args) {

        for (int i=0;i<100; i++){
            AtomicReference<AtomicEmplyee> atomicReference = new AtomicReference<>(new AtomicEmplyee(new AtomicReference<String>("Xasan"),new AtomicInteger(0)));
            Thread t1 = new Thread(()->{
                for (int j=1; j<=100; j++){
                    atomicReference.getAndUpdate(value->{
                        value.getAge().incrementAndGet();
                        return value;
                    });
                }
            });

            Thread t2 = new Thread(()->{
                for (int j=1; j<=100; j++){
                    atomicReference.getAndUpdate(value->{
                        value.getAge().incrementAndGet();
                        return value;
                    });
                }
            });
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(atomicReference.get());
        }

    }
}
