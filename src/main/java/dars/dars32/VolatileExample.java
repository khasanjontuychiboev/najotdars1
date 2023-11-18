package dars.dars32;

public class VolatileExample {
 private volatile boolean flag = false;
 public static void main(String[] args) {
 VolatileExample example = new VolatileExample();

 Thread writerThread = new Thread(() -> {
 try {
 Thread.sleep(1000);
 example.setFlag(true);
 System.out.println("Writer thread: Flag set to true");
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 });


 Thread readerThread = new Thread(() -> {
 while (!example.isFlag()) {
 // Busy-wait until the flag becomes true
 }
 System.out.println("Reader thread: Flag is now true");
 });
writerThread.start();
 readerThread.start();
 try {
 writerThread.join();
 readerThread.join();
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 System.out.println("Execution completed.");
 }
 public boolean isFlag() {
 return flag;
 }
 public void setFlag(boolean flag) {
 this.flag = flag;
 }
}