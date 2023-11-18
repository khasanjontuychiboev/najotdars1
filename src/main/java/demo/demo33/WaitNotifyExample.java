package demo.demo33;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();

        Thread senderThread = new Thread(new Sender(message));
        Thread receiverThread = new Thread(new Receiver(message));

        senderThread.start();
        Thread.sleep(50);
        receiverThread.start();
    }
}

class Message {
    private String content;
    private boolean hasNewMessage = false;

    public synchronized void send(String message) {
        while (hasNewMessage) {
            try {
                wait(); // Wait until the receiver consumes the previous message
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        content = message;
        hasNewMessage = true;
        notify(); // Notify the receiver that a new message is available
    }

    public synchronized String receive() {
        while (!hasNewMessage) {
            try {
                wait(); // Wait until a message is available
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasNewMessage = false;
        notify(); // Notify the sender that the message has been consumed
        return content;
    }
}

class Sender implements Runnable {
    private Message message;

    public Sender(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = { "Hello", "World", "Goodbye" };
        for (String msg : messages) {
            message.send(msg);
            System.out.println("Sent: " + msg);
            try {
                Thread.sleep(1000); // Simulate some delay between sending messages
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.send("END"); // Signal the end of messages
    }
}

class Receiver implements Runnable {
    private Message message;

    public Receiver(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String receivedMessage;
        while (!(receivedMessage = message.receive()).equals("END")) {
            System.out.println("Received: " + receivedMessage);
        }
    }
}