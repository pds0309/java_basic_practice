package com.el;

public class ElExamDTO {
    private String name;
    private int age;

    public ElExamDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "우리" + name + "이는 " + age + "쨜!";
    }
}
