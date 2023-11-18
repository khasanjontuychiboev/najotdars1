package dars.dars35;

class A {
    int num;
    boolean hasNumber = false;

    public synchronized void setNum() {
        for (int i = 1; i <= 10; i++) {
            while (hasNumber) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.num = i;
            hasNumber = true;
            System.out.println("Set: " + this.num);
            notify();
        }
    }

    public synchronized void getNum() {
        for (int i = 1; i <= 10; i++) {
            while (!hasNumber) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            hasNumber = false;
            System.out.println("Get:" + this.num);
            notify();
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        A obj = new A();
        Thread t1 = new Thread(() -> {
            obj.setNum();
        });

        Thread t2 = new Thread(() -> {
            obj.getNum();
        });

        t1.start();
        t2.start();
    }
}
