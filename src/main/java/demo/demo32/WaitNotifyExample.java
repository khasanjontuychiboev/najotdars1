package demo.demo32;

public class WaitNotifyExample {
    public static void main(String[] args) {
        final Message message = new Message();

        Thread producerThread = new Thread(() -> {
            String[] messages = {"Hello", "World", "Goodbye"};

            for (String msg : messages) {
                message.produce(msg);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (String msg : message.getMessages()) {
                message.consume();
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Message {
        private String message;
        private boolean hasMessage;

        public synchronized void produce(String msg) {
            while (hasMessage) {
                try {
                    wait(); // Wait until the message is consumed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            message = msg;
            hasMessage = true;
            System.out.println("Produced: " + message);
            notify(); // Notify the consumer thread that a message is available
        }

        public synchronized void consume() {
            while (!hasMessage) {
                try {
                    wait(); // Wait until a message is produced
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Consumed: " + message);
            hasMessage = false;
            notify(); // Notify the producer thread that the message has been consumed
        }

        public synchronized String[] getMessages() {
            return new String[]{"Hello", "World", "Goodbye"};
        }
    }
}