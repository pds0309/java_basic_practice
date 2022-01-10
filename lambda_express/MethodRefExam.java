import java.util.function.Function;

public class MethodRefExam {

  public static void main(String[] args) {
    // 기존
    Function<String, Integer> f = (s) -> Integer.parseInt(s);

    // 메소드 참조 방식
    // 람다식과 내부 메소드의 파라미터가 생략되는 형태이다.
    Function<String, Integer> ff = Integer::parseInt;
    int a = ff.apply("123");
    System.out.println(a);


    // static method 에서의 참조

    // before
    MyInterface<Integer, Integer> ss = (x, y) -> StaticClass.sum(x, y);

    // after
    ss = StaticClass::sum;
    ss.hi(5, 15);
    
    
    // 인스턴스 메소드에서의 참조
    InstanceClass ic = new InstanceClass();
    
    //before
    MyInterface<Integer , Integer> ii = (x,y) -> ic.sum(x, y); 
    
    //after
    ii = ic::sum;
    ii.hi(5, 15);
  }
 
}


@FunctionalInterface
interface MyInterface<T, V> {
  T hi(T t, V v);
}


class StaticClass {
  public static int sum(int x, int y) {
    return x + y;
  }
}


class InstanceClass {
  public int sum(int x, int y) {
    return x + y;
  }
}
