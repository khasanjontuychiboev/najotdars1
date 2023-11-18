package dars.dars32.dars35;

import java.util.ArrayList;

public class MaxsulorService {
    private ArrayList<Maxsulot> maxsulotlar = new ArrayList<>();

    public MaxsulorService() {
        this.maxsulotlar.add(new Maxsulot("Iphone", 100));
        this.maxsulotlar.add(new Maxsulot("samsung", 200));
        this.maxsulotlar.add(new Maxsulot("Mataorola", 300));
        this.maxsulotlar.add(new Maxsulot("Lg", 400));
        this.maxsulotlar.add(new Maxsulot("Mi5", 500));
    }

    public void doSomeThing(){
        for (int i=1; i<=10; i++){
            for (int j=0; j<maxsulotlar.size(); j++){
                Maxsulot vaqtMax = maxsulotlar.get(j);
                vaqtMax.setSoni(vaqtMax.getSoni()+1);
                System.out.println(vaqtMax + " called "+ Thread.currentThread().getName());
            }
        }
    }
}
