package demo.demo39;
class ClassA{
    public synchronized void methodA(){
        System.out.println("ClassA methodA started!...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ClassB classB = new ClassB();
        classB.methodB();
        System.out.println("ClassA methodA ended.");

    }
}

class ClassB{
    public synchronized void methodB(){
        System.out.println("ClassB methodB started!...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ClassA classA = new ClassA();
        classA.methodA();
        System.out.println("ClassB methodB ended.");
    }
}
public class CustomExucutorService {
    public static void main(String[] args) {
        ClassA objA = new ClassA();
        ClassB objB = new ClassB();
        new Thread(objA::methodA).start();
        new Thread(objB::methodB).start();

    }
}
