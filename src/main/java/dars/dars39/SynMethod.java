package dars.dars39;

class Resource39{
    private boolean isREady = false;
    private int soni = 20;
    public synchronized void tekShirish(){
        while (soni>0){
            while (isREady){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName()+" testni tekshirish");
            isREady  = true;
            soni--;
            notify();
        }
    }

    public synchronized void elonQilish(){
        while (soni>0){
            while (!isREady){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName()+" elon qilish");
            isREady  = false;
            notify();
        }
    }
}
public class SynMethod {
    public static void main(String[] args) {
        Resource39 obj = new Resource39();
        Thread t1 = new Thread(()->{
                obj.tekShirish();
        });
        Thread t2 = new Thread(()->{
                obj.elonQilish();
        });
        t1.start();
        t2.start();

    }
}
