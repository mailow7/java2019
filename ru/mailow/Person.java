package ru.mailow;

import java.util.Map;

public class Person {
    String name;
    int age;
    Map address;

    public Person(String name, int age, Map address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Map getAddress() {
        return address;
    }
}
