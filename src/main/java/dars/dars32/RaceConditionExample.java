package dars.dars32;

public class RaceConditionExample {
 private int counter = 0;

 public synchronized void increment() {
  int temp = counter;
  System.out.print("Before=" + temp);
  temp++;
  counter = temp;
  System.out.print("After=" + counter + " \n");
 }

 public int getCounter() {
  return counter;
 }

 public static void main(String[] args) {
  RaceConditionExample example = new RaceConditionExample();
  Runnable task = () -> {
   for (int i = 0; i < 1000; i++) {
    example.increment();
   }
  };
  Thread thread1 = new Thread(task);
  Thread thread2 = new Thread(task);
  thread1.start();
  thread2.start();
  try {
   thread1.join();
   thread2.join();
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
  System.out.println("Final Counter Value: " + example.getCounter());
 }
}