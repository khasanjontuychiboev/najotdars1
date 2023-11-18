package dars.dars32.dars35;

class ClassName extends Thread{
    public void salom(){
        System.out.println("salom...");
    }

    @Override
    public void run() {
        System.out.println("Yangi thread class...");
        salom();
    }
    
}