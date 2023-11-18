package dars.dars32;

public class RunClass implements Runnable{

    private int c;
    @Override
    public void run() {
        String threadName = Thread.currentThread()
                .getName();
        for (int i = 0; i < 1000; i++) {
            System.out.println(threadName + " started. "+ Thread.currentThread().getPriority());
            c++;
        }
        System.out.println(threadName + " ended.");
    }

}
