package reflection;

public class Parent {
    private String name;
    private int age;

    public Parent() {
        this.name = "parent";
        this.age = 25;
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Parent(String name) {
        this.name = name;
        this.age = 999;
    }

    public String getName() {
        return name;
    }

    private void hello() {
        System.out.println("HELLO");
    }

    public int getAge() {
        return age;
    }
}
