package demo.demo32;

public class YieldExample {
    public static void main(String[] args) {
        Thread highPriorityThread = new MyThread();
        highPriorityThread.setName("High Priority Thread");
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        Thread lowPriorityThread = new MyThread();
        lowPriorityThread.setName("Low Priority Thread");
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " started.");

            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " executing iteration " + i);

                // Introducing some delay
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Allowing other threads to run
                Thread.yield();
            }

            System.out.println(threadName + " ended.");
        }
    }
}