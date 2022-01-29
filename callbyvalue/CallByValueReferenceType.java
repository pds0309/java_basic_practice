public class CallByValueReferenceType {

    public static void main(String[] args) {
      A a = new A("ABC");
      int aCode = a.hashCode();
      run(a);
      System.out.println(a.name); // KKK 출력
    }
    static void run(A aInput) {
      aInput.name = "KKK";
      int aInputCode = aInput.hashCode();
    }
}

class A {
    String name;

    public A(String name) {
      this.name = name;
    }
}