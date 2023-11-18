package dars.dars37.semfor;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore  = new Semaphore(1);
        ExampleBank obj= new ExampleBank(semaphore);

        for (int i=0; i<10; i++){
            new Thread(obj::bankXimati).start();
        }

    }
}
