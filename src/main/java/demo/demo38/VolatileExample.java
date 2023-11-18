package demo.demo38;

class ExampleVol {
    private volatile boolean stopRequest = false;
    public void doIncrease(){
        int i = 0;
        while (!stopRequest){
            i++;
        }
        System.out.println(Thread.currentThread().getName()+" done.");
    }
    public void changeBoolean(){
        stopRequest = true;
    }
}
public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        ExampleVol obj = new ExampleVol();
        new Thread(obj::doIncrease).start();

        Thread.sleep(2000);
        obj.changeBoolean();
        System.out.println("Main Thread done!");
    }
}
