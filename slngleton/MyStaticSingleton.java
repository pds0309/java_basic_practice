package singleton_practice;

public class MyStaticSingleton {
  private static MyStaticSingleton instance = new MyStaticSingleton();

  private MyStaticSingleton() {
    System.out.println("My Singleton 초기화!!" + (int) (Math.random() * 1000));
  }

  public static MyStaticSingleton getInstance() {
    return instance;
  }
}
