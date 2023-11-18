package dars.dars34;

import java.util.Vector;

class Something{
    public synchronized void saySomething(){
        for (int i=1; i<=10; i++){
            System.out.println("Say something is called by "
                    + Thread.currentThread().getName()
                    + " i = "+i);
        }
    }
}
public class WithoutThread {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> toplam = new Vector<>();

        System.out.println("Main thread waited 5 sekund");
        System.out.println(toplam);
    }
}
