package demo.demo38;

import java.util.concurrent.atomic.AtomicReference;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person {
    private int rollNumber;

    public Student(String name, int rollNumber) {
        super(name);
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
}

public class AtomicReferenceExample {
    public static void main(String[] args) {
        AtomicReference<Person> atomicPerson = new AtomicReference<>(new Person("John"));

        // Update the name of the person atomically
        atomicPerson.updateAndGet(person -> {
            person.setName("Alice");
            return person;
        });

        System.out.println("Updated name: " + atomicPerson.get().getName());

        // Create a new student and set it atomically
        Student newStudent = new Student("Bob", 123);
        atomicPerson.set(newStudent);

        System.out.println("Student name: " + atomicPerson.get().getName());
        System.out.println("Student roll number: " + ((Student) atomicPerson.get()).getRollNumber());
    }
}