package com.example.firstexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Person")
public class Person {
    @Id
    private Long id;
    private String Name;
    private String SSN;
    private int Age;
    private int Salary;

    public Person() {

    }
    public Person(Long id, String name, String SSN, int age, int salary) {
        this.id = id;
        Name = name;
        this.SSN = SSN;
        Age = age;
        Salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", SSN='" + SSN + '\'' +
                ", Age=" + Age +
                ", Salary=" + Salary +
                '}';
    }
}
