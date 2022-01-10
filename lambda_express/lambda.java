import java.util.Arrays;

public class lambda {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    int[] arr = new int[5];
    Arrays.setAll(arr, (i)->{return (int)(Math.random()*5)+1;});    
    Exam e = () -> System.out.println();
    Exam ee = new Exam() {
      @Override
      public void run() {
         System.out.println("hi");
      }
    };
    ee.run();
  }
}

interface Exam {
  void run();
}
