package lambda.exam;

public class LambdaTest {

  // 람다 표현식

  // 등장배경
  // - 기능(메소드)에 집중하자!
  // - 함수형 프로그래밍의 기반이 된다.
  //
  // 인터페이스 작성 후 사용하는 방법 3개
  // - 이름있는 클래스
  // - 익명 클래스
  // - 람다 표현식
  // - 모든 인터페이스를 람다표현식으로 변경하는 것은 불가능
  // - 반드시 하나의 추상 메소드를 가진 인터페이스만 람다 표현식으로 변경 가능
  // - 메소드의 기능에 따른 분류 4가지
  // - 파라미터가 있고 없고?? 리턴이 있고 없고??
  // - @FunctionalInterface => 반드시 하나의 추상 메소드만 가지는 것을 강제시킴

  // 자바는 기능에만 집중이 불가능
  // - 자바 기본 단위가 클래스고 클레스 안에 메소드를 넣어서 사용하게 된다.

  // 함수형 프로그래밍
  // - 클래스를 투명하게 해서 기능을 사용?
  // - 인터페이스 기반


  // 람다표현
  // - 익명클래스를 통해 기능(메소드)만 사용하자



  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 익명클래스 방법
    Flyer f = new Flyer() {
      @Override
      public void fly() {
        // TODO Auto-generated method stub
        System.out.println("hi");
      }
    };
    f.fly();

    // 람다 표현식 1 => 파라미터도 없고 리턴도 없는 추상 메소드
    // 표현은 이래도 실제로는 익명클래스가 랩 되는 형태이다.

    // => : js
    // -> : 자바
    Flyer f2 = () -> System.out.println("hi");
    
    // 어차피 인터페이스에 추상 메소드가 한개기때문에 그걸 실행할 수 있음
    f2.fly();

    // 람다 표현식2 => 파라미터는 있고 리턴이 없는 추상 메소드
    Flyer2 ff1 = (v, x) -> {
      System.out.println(v + x);
    };

    ff1.fly(5, "hello");

    // 람다 표현식3 -> 파라미터는 없고 리턴이 있는 추상 메소드
    Flyer3 ff3 = () -> {
      return 5;
    };

    // 리턴문장만있으면 중괄호와 리턴 생략가능
    ff3 = () -> 5;
    System.out.println(ff3.fly());
    int a = ff3.fly();
    System.out.println(a);



    // 익명 클래스 4 -> 파라미터와 리턴이 모두 있는

    Flyer5 f5 = new Flyer5() {
      @Override
      public int fly(int a, int b) {
        return a + b;
      }
    };
    System.out.println(f5.fly(3, 15));
    
    // 람다 표현식 4 -> 파라미터와 리턴이 모두 있는 추상 메소드
    Flyer5 ff5 = (x, y) -> x + y;
    System.out.println(ff5.fly(3, 15));
  
    
  }

}


@FunctionalInterface
interface Flyer {
  public abstract void fly();
}


@FunctionalInterface
interface Flyer2 {
  public abstract void fly(int a, String b);
}


@FunctionalInterface
interface Flyer3 {
  public abstract int fly();
}


@FunctionalInterface
interface Flyer5 {
  public abstract int fly(int a, int b);
}
