package singleton_practice;

public class MySingleton {

  private static MySingleton instance;
  
  private MySingleton() {
    System.out.println("My Singleton 초기화!!" + (int)(Math.random()*1000));
  }

  public static MySingleton getInstance() {
    if(instance == null) {
      instance = new MySingleton();
    }
    return instance;
  }
}
