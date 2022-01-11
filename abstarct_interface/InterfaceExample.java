
public class InterfaceExample {

  public static void main(String[] args) {
      Dopable d = new Marine2();
      d = new FireBat();
      
  }

}

class Marine2 extends Unit implements Dopable {
  @Override
  void move(int x, int y) {}

  @Override
  public void stimPack() {}
}


class FireBat extends Unit implements Dopable {
  @Override
  void move(int x, int y) {}

  @Override
  public void stimPack() {}
}


interface Dopable {
  public abstract void stimPack();
}
