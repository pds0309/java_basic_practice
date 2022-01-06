package innerclass.exam;

public class AnonyExam {

  public static void main(String[] args) {
    A a = new A();
    a.run();
    
    Playable p = new Playable() {
      @Override
      public void runAway() {
        System.out.println("익명 달려");
      }
      @Override
      public void run() {
        System.out.println("익명 도망쳐");
      }
    };
    p.run();
  }
}


interface Playable {
  void run();
  void runAway();
}

// 이름있는 클래스 만들고 구현하는 예시
class A implements Playable{

  @Override
  public void run() {
    System.out.println("뛰어");
  }

  @Override
  public void runAway() {
    System.out.println("도망쳐");
  }
  
}