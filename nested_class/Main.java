package innerclass.exam;

import innerclass.exam.Outer.Inner;



//EX) 뷰 -> 화면처리: Outer / 이벤트 : Inner


// Outer 클래스
class Outer {
  // inner 클래스에서 멤버변수에 모두 접근할 수 있다.
  public int n = 10;
  protected int n2 = 20;
  int n3 = 30;
  private int n4 = 40;
  static int n5 = 5;
  public void methodOuter() {
    Inner i = new Inner();
    i.methodInner();
  }
  // Inner Class 만드는이유 -> Outer 에서만 사용하는 클래스 필요시  
  class Inner {
    int x = 100;
    // Inner class 는 Static 멤버를 가지지 못한다.
    // static int y = 1;
    public void methodInner() {
      // outer의 private 멤버에도 접근할 수 있따.
      System.out.println(n4);
      System.out.println(n5);
    }
  }
}


public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Outer outer = new Outer();
    outer.methodOuter();    
  }
}

class B extends Outer{
  public void run() {
    Inner i  = new Inner();
    i.methodInner();
  }
}