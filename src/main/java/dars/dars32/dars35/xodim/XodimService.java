package dars.dars32.dars35.xodim;

import java.util.ArrayList;

public class XodimService {
    private ArrayList<Xodim> xodimlar = new ArrayList<>();

    public XodimService() {
        xodimlar.add(new Xodim("Xasan", 100));
        xodimlar.add(new Xodim("Xusan", 1000));
        xodimlar.add(new Xodim("Zuhra", 150));
        xodimlar.add(new Xodim("Fotima", 300));
        xodimlar.add(new Xodim("Ali", 1200));
    }

    public synchronized void doSomeThing(){

        for (Xodim x: xodimlar) {
            x.setSalary(x.getSalary()+10);
            System.out.println(
                    x + " called By "+
                    Thread.currentThread().getName()
            );
        }
    }
}
