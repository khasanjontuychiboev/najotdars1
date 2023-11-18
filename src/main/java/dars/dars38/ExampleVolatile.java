package dars.dars38;

class VolatileClass{
    private volatile boolean stop = false;

    public void increment(){
        int i = 0;
        while (!stop){
            i++;
        }
        System.out.println("jaraoyon tugadi!");
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
public class ExampleVolatile {
    public static void main(String[] args) throws InterruptedException {
        VolatileClass obj = new VolatileClass();

        Thread t1 = new Thread(()->{
            obj.increment();
        });
        t1.start();
        Thread.sleep(1000);
        obj.setStop(true);

    }
}
