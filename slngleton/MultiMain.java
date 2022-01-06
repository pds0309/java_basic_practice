package singleton_practice;

public class MultiMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MultiThread[] mt = new MultiThread[6];
    for (int i = 0; i < 6; i++) {
      mt[i] = new MultiThread();
      mt[i].start();
    }
  }

}
class MultiThread extends Thread {
  MultiThread() {}

  public void run() {
    try {
      MySingleton mySingleton = MySingleton.getInstance();
      MySyncSingleton syncSingleton = MySyncSingleton.getInstance();
      /* Source */
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
