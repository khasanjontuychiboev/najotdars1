package dars.dars33;

class Sender implements Runnable {
    private Message message;

    public Sender(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Hello", "World", "Goodbye", "Xabar"};
        for (String msg : messages) {
            try {
                message.send(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Sent: " + msg);

        }
        try {
            message.send("END"); // Signal the end of messages
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}