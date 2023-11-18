package demo.demo39;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

class PlasticCard {

    private final AtomicReference<Double> amount = new AtomicReference<>(1000D);

    public void acceptMoney(Double acceptedMoney) {
        amount.updateAndGet(v -> v + acceptedMoney);
    }

    public void sendMoney(Double sendedMoney) {
        amount.updateAndGet(v -> v - sendedMoney);

    }

    public AtomicReference<Double> getAmount() {
        return amount;
    }
}

public class Demo39 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        PlasticCard plasticCard = new PlasticCard();

        executorService.submit(() -> {
            for (int j = 0; j < 10; j++) {
                plasticCard.sendMoney(10D);
            }
        });

        System.out.println(plasticCard.getAmount().get());
        executorService.shutdown();
    }
}
