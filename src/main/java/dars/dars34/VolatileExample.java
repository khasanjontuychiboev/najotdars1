package dars.dars34;

public class VolatileExample {
    private boolean flagWithoutVolatile = false;
    private volatile boolean flagWithVolatile = false;

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.setFlagWithoutVolatile(true);
            example.setFlagWithVolatile(true);
            System.out.println("Writer thread has updated the flags.");
        });

        Thread readerThread = new Thread(() -> {
            while (!example.isFlagWithoutVolatile()) {
                // Do nothing, just wait
            }
            System.out.println("Reader thread detected the updated flag (without volatile).");
        });

        Thread volatileReaderThread = new Thread(() -> {
            while (!example.isFlagWithVolatile()) {
                // Do nothing, just wait
            }
            System.out.println("Reader thread detected the updated flag (with volatile).");
        });

        writerThread.start();
        readerThread.start();
        volatileReaderThread.start();
    }

    public boolean isFlagWithoutVolatile() {
        return flagWithoutVolatile;
    }

    public void setFlagWithoutVolatile(boolean flagWithoutVolatile) {
        this.flagWithoutVolatile = flagWithoutVolatile;
    }

    public boolean isFlagWithVolatile() {
        return flagWithVolatile;
    }

    public void setFlagWithVolatile(boolean flagWithVolatile) {
        this.flagWithVolatile = flagWithVolatile;
    }
}