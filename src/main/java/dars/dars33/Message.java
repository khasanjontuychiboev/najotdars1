package dars.dars33;

class Message {
    private String content;
    private boolean hasNewMessage = false;

    public synchronized void send(String message) throws InterruptedException {
        while (hasNewMessage){
            wait();
        }
        content = message;
        hasNewMessage = true;
        Thread.sleep(100);
        notify();
    }

    public synchronized String receive(){
        while (!hasNewMessage){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        hasNewMessage=false;
        notify();
        return content;
    }
}