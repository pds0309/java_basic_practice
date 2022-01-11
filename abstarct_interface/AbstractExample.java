
public class AbstractExample {

  public static void main(String[] args) {

    Unit[] unitArr = {new Marine(), new DropShip(), new Marine()};
    for (int i = 0; i < unitArr.length; i++) {
      unitArr[i].move(100, 200);
    }
  }

}

abstract class Unit {
  int x;
  int y;

  abstract void move(int x, int y);

  void stop() {};
}


class Marine extends Unit {
  @Override
  void move(int x, int y) {};

  void stimPack() {};
}


class DropShip extends Unit {
  @Override
  void move(int x, int y) {}

  void load() {};

  void unLoad() {};
}
