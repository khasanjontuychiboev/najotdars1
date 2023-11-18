package dars.dars36;

class Source{
    public int count;
    public synchronized void nameMethod(){
        for (int i=1;i<=10; i++) {
            count++;
            System.out.println(Thread.currentThread().getName()+ " count ="+ count);
        }
    }

}

public class ExampleClass {
    public static void main(String[] args) {
        Source obj = new Source();

        Thread t1 = new Thread(()->{
                obj.nameMethod();
        });

        Thread t2 = new Thread(()->{
                obj.nameMethod();
        });

        t1.start();
        t2.start();

    }
}
