package com.example.model;

public class Person implements Comparable<Person> {
    private String name;
    private String birthDate;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}