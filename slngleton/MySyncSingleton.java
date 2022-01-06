package singleton_practice;

public class MySyncSingleton {
  private static MySyncSingleton instance;

  private MySyncSingleton() {
    System.out.println("My Sync Singleton 초기화!!" + (int)(Math.random()*1000));
  }

  public static synchronized MySyncSingleton getInstance() {
    if (instance == null) {
      instance = new MySyncSingleton();
    }
    return instance;
  }
}
