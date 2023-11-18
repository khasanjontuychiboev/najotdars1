package demo.demo38;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicEmplyee {
    private final AtomicReference<String> name;
    private final AtomicInteger age;

    public AtomicEmplyee(AtomicReference<String> name, AtomicInteger age) {
        this.name = name;
        this.age = age;
    }

    public AtomicReference<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public AtomicInteger getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age.set(age);
    }

    @Override
    public String toString() {
        return "AtomicEmplyee{" +
                "name='" + name.get() + '\'' +
                ", age=" + age.get() +
                '}';
    }
}
