package innerclass.exam;

import innerclass.exam.Outer.Inner;



// EX) 뷰 -> 화면처리: Outer / 이벤트 : Inner


// Outer 클래스
class Outer2 {
  public int n = 10;
  protected int n2 = 20;
  int n3 = 30;
  private int n4 = 40;
  private static int n5 = 50;

  public void methodOuter() {
    int x = 10;
    // 2. Local Inner Class
    class Inner {
      int z = 200;

      public void methodInner() {
        System.out.println(n4);
      }
    }
  }

  // 3. Static Inner Class
  static class Inner3 {
    int a = 10;
    // Static 사용 가능
    static int b = 15;

    public static void methodInner() {
      System.out.println(n5);
    }
  }
}
public class Main2 {
  
  public static void main(String[] args) {
    Outer2.Inner3.methodInner();
  }
}

