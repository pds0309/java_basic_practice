package inter.exam;

public interface Flyer {

  public abstract void takeOfF();

  public abstract void fly();

  public abstract void land();
}


// 디커플링

// 모듈 사이를 인터페이스로 연결하고 구현체를 분리하는 것

// 한쪽 클래스에서의 변경이 다른 클래스에 영향을 주면 안된다.

