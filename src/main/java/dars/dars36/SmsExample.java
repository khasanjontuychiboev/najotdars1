package dars.dars36;

class Sms{
    int smsPaket = 100;
}

class SmsServie{

    Sms sms = new Sms();

    boolean isready = false;

    public void smsWrite(){
        System.out.println("Salom...writer start");
        synchronized (sms){
            while (sms.smsPaket>0){
                if (isready){
                    try {
                        sms.wait();
                    }catch (Exception e){e.printStackTrace();}
                }
                sms.smsPaket--;
                System.out.println(Thread.currentThread().getName()+" yangi sms yozildi send");
                isready=true;
                sms.notify();
            }
        }

        System.out.println("Salom...write end");


    }

    public void smsRead(){
        System.out.println("Salom...reader start");

        synchronized (sms){
            while (sms.smsPaket>0){
                if (!isready){
                    try {
                        sms.wait();
                    }catch (Exception e){e.printStackTrace();}
                }

                System.out.println(Thread.currentThread().getName()+" yangi sms oqildi");
                isready=false;
                sms.notify();
            }
        }

        System.out.println("Salom...reader end");

    }
}
public class SmsExample {
    public static void main(String[] args) {
        SmsServie servie = new SmsServie();

        Thread t1 = new Thread(()->{
            servie.smsWrite();
        },"Jonatuvchi");

        Thread t2 = new Thread(()->{
            servie.smsRead();
        },"Qabulqiluvchi");


        t1.start();
        t2.start();
    }
}
