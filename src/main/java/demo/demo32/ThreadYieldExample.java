package demo.demo32;

public class ThreadYieldExample {
    public static void main (String[] args) {
        Task task1 = new Task(true);
        Thread t1 = new Thread(task1);
        t1.start();

        Task task2 = new Task(false);
        Thread t2 = new Thread(task2);
        t2.start();

    }

    private static class Task implements Runnable {
        private final boolean shouldYield;
        private int c;

        public Task(boolean shouldYield){
            this.shouldYield = shouldYield;
        }
        @Override
        public void run () {
            String threadName = Thread.currentThread()
                                      .getName();

            System.out.println(threadName + " started.");
            for (int i = 0; i < 1000; i++) {
                c++;
                System.out.println(threadName);


                if(shouldYield){
                    Thread.yield();
                }
            }

            System.out.println(threadName + " ended.");
        }
    }
}