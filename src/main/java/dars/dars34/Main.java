package dars.dars34;

class Hi extends Thread{
    public static final Hi hi = new Hi();

    public void run(){
            System.out.println(Thread.currentThread().getName()+" call method of -> "+hi.getName());
            hi.intermediteMethod();
    }
    public synchronized void intermediteMethod(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " run i= "+i);
        }
    }
}


public class Main {
    public static void main(String[] args){
        Hi hi = new Hi();
        hi.setName("Birinchi");

        Hi hi2 = new Hi();
        hi2.setName("Ikkinchi");


        hi.start();
        hi2.start();

        System.out.println("Main thread end.");

    }
}
