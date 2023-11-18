package dars.dars38;

import java.util.concurrent.atomic.AtomicReference;

class Employee2{
     private final AtomicReference<Double> salary = new AtomicReference<>(0D);

    public AtomicReference<Double> getSalary() {
        return salary;
    }

    public void oshirish(Double x){
        salary.updateAndGet(v->v+x);
    }

}
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        Employee2 obj = new Employee2();

        Thread t1 = new Thread(()->{
            for (int i=0; i<1000;i++){
                obj.oshirish(1D);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i=0; i<1000;i++){
                obj.oshirish(2D);
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(obj.getSalary().get());
    }
}
