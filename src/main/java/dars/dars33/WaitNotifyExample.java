package dars.dars33;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();

        Thread senderThread = new Thread(new Sender(message));
        Thread receiverThread = new Thread(new Receiver(message));

        senderThread.start();
        Thread.sleep(500);
        receiverThread.start();
    }
}