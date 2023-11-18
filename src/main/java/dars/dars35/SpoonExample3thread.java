package dars.dars35;

class Spoon{
    int soup = 10;
    SpoonStatus spoonStatus = SpoonStatus.EMPTY_FOR_CHILD;
    public synchronized void useChild(){
        while (soup>0){
            while (spoonStatus != SpoonStatus.EMPTY_FOR_CHILD){
                try {
                    wait();
                }catch (Exception e){e.printStackTrace();}
            }
            System.out.println("Child use the spoon");
            soup--;
            spoonStatus = SpoonStatus.EMPTY_FOR_MUM;
            notifyAll();
        }
    }

    public synchronized void useMum(){
        while (soup>0){
            while (spoonStatus != SpoonStatus.EMPTY_FOR_MUM){
                try {
                    wait();
                }catch (Exception e){e.printStackTrace();}
            }
            System.out.println("Mum use the spoon");
            soup--;
            spoonStatus = SpoonStatus.EMPTY_FOR_DAD;
            notifyAll();
        }
    }

    public synchronized void useDad(){
        while (soup>0){
            while (spoonStatus != SpoonStatus.EMPTY_FOR_DAD){
                try {
                    wait();
                }catch (Exception e){e.printStackTrace();}
            }
            System.out.println("Dad use the spoon");
            soup--;
            spoonStatus = SpoonStatus.EMPTY_FOR_CHILD;
            notifyAll();
        }
    }

}
enum SpoonStatus{
    EMPTY_FOR_DAD,
    EMPTY_FOR_MUM,
    EMPTY_FOR_CHILD
}
public class SpoonExample3thread {
    public static void main(String[] args) {
        Spoon spoon = new Spoon();
        Thread childThread = new Thread(()->{
            spoon.useChild();
        });
        Thread mumThread = new Thread(()->{
            spoon.useMum();
        });
        Thread dadThread = new Thread(()->{
            spoon.useDad();
        });

        childThread.start();
        mumThread.start();
        dadThread.start();
    }

}
