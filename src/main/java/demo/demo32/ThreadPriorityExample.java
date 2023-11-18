package demo.demo32;

public class ThreadPriorityExample {
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

            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 1000) {
                // Simulating a time-consuming task
            }

            System.out.println(threadName + " ended.");
        }
    }
}