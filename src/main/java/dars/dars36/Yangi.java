package dars.dars36;

class A{
    int num;
    boolean ruchkaImronbek = false;

    public void doImronbek(){
        synchronized (this){
            for (int i=1;i<=10; i++){
                if (!ruchkaImronbek){
                    try {
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                num = num+i;
                System.out.println(Thread.currentThread().getName());
                ruchkaImronbek = false;
                notify();

            }
        }

    }

    public  void doDavron(){
        synchronized (this){

            for (int i=1;i<=10; i++){
                if (ruchkaImronbek){
                    try {
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                num = num+i;
                System.out.println(Thread.currentThread().getName());
                ruchkaImronbek = true;
                notify();
            }
        }
    }
}
public class Yangi {

    public static void main(String[] args) throws InterruptedException {
        A obj = new A();

        Thread i = new Thread(()->{
            obj.doImronbek();
        });

        Thread d = new Thread(()->{
            obj.doDavron();
        });

        i.start();
        d.start();

        i.join();
        d.join();

    }
}
