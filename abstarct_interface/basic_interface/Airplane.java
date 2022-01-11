package inter.exam;

public class Airplane implements Flyer {

  @Override
  public void takeOfF() {
    // TODO Auto-generated method stub
    System.out.println("비행기 이륙");
  }

  @Override
  public void fly() {
    // TODO Auto-generated method stub
    System.out.println("비행기 날다");
  }

  @Override
  public void land() {
    // TODO Auto-generated method stub
    System.out.println("비행기 착륙");
  }

}
