package demo.demo32;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread nonDaemonThread = new Thread(new Task());
        nonDaemonThread.setName("Non-Daemon Thread");

        Thread daemonThread = new Thread(new Task());
        daemonThread.setName("Daemon Thread");
//        daemonThread.setPriority(Thread.MIN_PRIORITY);
        daemonThread.setDaemon(true);

        nonDaemonThread.start();
        daemonThread.start();

        System.out.println("Main Thread exiting.");
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            int count = 1;

            while (count <= 5) {
                System.out.println(threadName + " executing iteration " + count++);
                try {
                    if (Thread.currentThread().getPriority()==Thread.MIN_PRIORITY){
                        Thread.sleep(1000);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " ended.");
        }
    }
}