package inter.exam;

public class Bird implements Flyer{

  @Override
  public void takeOfF() {
    // TODO Auto-generated method stub
    System.out.println("새 이륙하다");
  }

  @Override
  public void fly() {
    // TODO Auto-generated method stub
    System.out.println("새 날다");
  }

  @Override
  public void land() {
    // TODO Auto-generated method stub
    System.out.println("새 착륙하다");
  }

}
