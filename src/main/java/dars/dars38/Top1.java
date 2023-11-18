package dars.dars38;

import java.util.concurrent.atomic.AtomicInteger;

class Student1{
    private AtomicInteger ball = new AtomicInteger(50);

    public void ballOshir(){
        ball.incrementAndGet();
    }

    public AtomicInteger getBall() {
        return ball;
    }
}
public class Top1 {
    public static void main(String[] args) throws InterruptedException {
        for (int j=0; j<100; j++){
            Student1 obj = new Student1();

            Thread t1 = new Thread(()->{
                for (int i=0; i<10;i++){
                    obj.ballOshir();
                }
            });


            Thread t2 = new Thread(()->{
                for (int i=0; i<10;i++){
                    obj.ballOshir();
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println(obj.getBall().get());
        }
    }
}
