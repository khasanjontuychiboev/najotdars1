package dars.dars32.dars35.xodim;

public class Xodim {
    private String name;
    private Integer salary;

    public Xodim(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Xodim{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
