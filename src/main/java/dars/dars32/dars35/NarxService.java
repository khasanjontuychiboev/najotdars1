package dars.dars32.dars35;

import java.util.ArrayList;

public class NarxService {
    private ArrayList<Double> narxlar = new ArrayList<>();

    public NarxService() {
        narxlar.add(100D);
        narxlar.add(100D);
        narxlar.add(100D);
        narxlar.add(100D);
        narxlar.add(100D);
        narxlar.add(100D);
    }

    public void doSomething(){
        for (Double narx : narxlar) {
            System.out.println(narx
                    + " called by "
                    + Thread.currentThread().getName());
        }
    }
}
