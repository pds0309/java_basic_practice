package reflection;

public class Child extends Parent {
    private String address;
    public String hello = "hello";

    public Child() {
        this.address = "주소";
    }

    private Child(String address) {
        this.address = address;
    }

    private void childHello() {
        System.out.println("HELLO_CHILD");
    }

    public void childHell() {
        System.out.println("HELL_CHILD");
    }

    @Override
    public String getName() {
        return super.getName() + "c";
    }
}
