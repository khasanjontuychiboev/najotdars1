package dars.dars33;

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