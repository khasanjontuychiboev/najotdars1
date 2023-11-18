package dars.dars32.dars35;

public class Maxsulot {
    private String nomi;
    private Integer soni;

    public Maxsulot(String nomi, Integer soni) {
        this.nomi = nomi;
        this.soni = soni;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public Integer getSoni() {
        return soni;
    }

    public void setSoni(Integer soni) {
        this.soni = soni;
    }

    @Override
    public String toString() {
        return "Maxsulot{" +
                "nomi='" + nomi + '\'' +
                ", soni=" + soni +
                '}';
    }
}
