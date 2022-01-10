import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefConstructExam {

  public static void main(String[] args) {
    
    
    // 인자 없는 생성자
      // 람다식
    Supplier<MyClassA> s = () -> new MyClassA();
      // 메소드 참조 방식
    s = MyClassA::new; 
    

    // 인자 있는 생성자
    // 알아서 필요한 매개변수에 맞춰서 사용해야한다.
    
      // 람다식
    BiFunction<String, Integer, MyClassA> bf = (x,y) -> new MyClassA(x,y);
    bf.apply("김갑환", 25);
    
      // 메소드 참조 방식
    bf = MyClassA::new;
    bf.apply("최번개", 19);
    
    
    // 배열
      // 람다식
    Function<Integer, int[]> f = x -> new int[x];
      // 메소드 참조 방식
    f = int[]::new;
  }

}


class MyClassA {

  String name;
  int age;
  public MyClassA() {}
  public MyClassA(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
