package demo.demo32;

public class ThreadInterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyTask());
        thread.start();

        // Let the thread run for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before intterupt");
        // Interrupt the thread
        thread.interrupt();
    }

    private static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().isInterrupted());
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Task is running...");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // Handle the interrupt signal
                    System.out.println("Task interrupted.");
                    // Restore the interrupt status
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Task finished.");
        }
    }
}