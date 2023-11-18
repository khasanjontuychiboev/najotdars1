package dars.dars36;


public class Main {
    public static void main(String[] args) throws InterruptedException {
       for (int j=0; j<=10; j++){

           StringBuilder s = new StringBuilder();

           Thread t1 = new Thread(()->{
               for (int i=1; i<=100;i++){
                   s.append("A");
               }
           });


           Thread t2 = new Thread(()->{
               for (int i=1; i<=100;i++){
                   s.append("B");
               }
           });

           t1.start();
           t2.start();

           t1.join();
           t2.join();

           System.out.println(s.length());
       }

    }
}
