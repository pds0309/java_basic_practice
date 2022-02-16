package com;

public class PersonDTO {
    private int age;
    private String name;
    public PersonDTO(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
