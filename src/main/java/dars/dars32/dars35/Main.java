package dars.dars32.dars35;

import dars.dars32.dars35.xodim.XodimService;

public class  Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            XodimService obj = new XodimService();
                obj.doSomeThing();

        });

        Thread t2 = new Thread(()->{
            XodimService obj = new XodimService();
                obj.doSomeThing();

        });

        t1.start();
        t2.start();


    }
}
