package inter.exam;

public class Superman implements Flyer{

  public void superTakeOff() {

  }

  @Override
  public void takeOfF() {
    // TODO Auto-generated method stub
    System.out.println("슈퍼맨 이륙하다");
  }

  @Override
  public void fly() {
    // TODO Auto-generated method stub
    System.out.println("슈퍼맨 날다");
  }

  @Override
  public void land() {
    // TODO Auto-generated method stub
    System.out.println("슈퍼맨 착륙하다");
  }
  
}
