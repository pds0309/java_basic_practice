package singleton_practice;

public class MyLazyHolderSingleton {

  private MyLazyHolderSingleton() {
    System.out.println("My Sync Singleton 초기화!!" + (int) (Math.random() * 1000));
  }

  public static MyLazyHolderSingleton getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {
    private static final MyLazyHolderSingleton INSTANCE = new MyLazyHolderSingleton();
  }
}
