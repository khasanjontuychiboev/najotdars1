package dars.dars34.maxsulot;

import java.util.List;



public class MaxsulotService {

    private List<Maxsulot> maxsulotlar = List.of(
            new Maxsulot("Komputer",10),
            new Maxsulot("SmartPhone",50),
            new Maxsulot("Kitob",100)
    );

    public void soniniOshir(){
        for (Maxsulot maxsulot : maxsulotlar) {
            ++maxsulot.soni;
            System.out.println(maxsulot.nomi+" soni "
                    + maxsulot.soni+
                    " called by "+Thread.currentThread().getName());
        }
    }





}
