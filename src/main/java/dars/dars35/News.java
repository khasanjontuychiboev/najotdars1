package dars.dars35;

public class News {
    String content;
    ContentStatus status = ContentStatus.PRODUCER_CAN_WRITE;

    public synchronized void produce() {
        for (int i = 1; i <= 10; i++) {
            while (status != ContentStatus.PRODUCER_CAN_WRITE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.content = "Content" + i;
            System.out.println(Thread.currentThread().getName() + " set: " + this.content);
            status = ContentStatus.READER_CAN_READ;
            notifyAll();
        }
    }

    public void reader() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                while (status != ContentStatus.READER_CAN_READ) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " read: " + this.content);
                status = ContentStatus.PRODUCER_CAN_WRITE;
                notifyAll();
            }


        }


    }

    enum ContentStatus {
        PRODUCER_CAN_WRITE,
        READER_CAN_READ
    }
}