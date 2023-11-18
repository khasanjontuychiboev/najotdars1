package dars.dars37;

import java.util.concurrent.CountDownLatch;

class Course{
    private CountDownLatch latch;

    public Course(CountDownLatch latch) {
        this.latch = latch;
    }

    public void sotibOlinishi(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Kurs sotib olindi...");
        latch.countDown();//0
    }

    public void rekka(){
        System.out.println("Kursni recomendatsiyaga chiqarildi!");
    }
}
public class UdemyCourse {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Course course = new Course(countDownLatch);
        for (int i=0; i<100; i++){
            new Thread(course::sotibOlinishi).start();
        }
        countDownLatch.await();
        System.out.println("davomi etadi");
        course.rekka();
    }
}
