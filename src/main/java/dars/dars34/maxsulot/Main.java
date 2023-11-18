package dars.dars34.maxsulot;

public class Main {
    public static void main(String[] args) {
        MaxsulotService maxsulotService = new MaxsulotService();
        Thread t1 = new Thread(()->{
            for (int i=1; i<=10;i++){
                maxsulotService.soniniOshir();
                System.out.println("=======");

            }
        });

        Thread t2 = new Thread(()->{
            for (int i=1; i<=10;i++){
                maxsulotService.soniniOshir();
                System.out.println("=======");
            }
        });
        t1.start();
        try {
            t1.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        t2.start();
    }
}
