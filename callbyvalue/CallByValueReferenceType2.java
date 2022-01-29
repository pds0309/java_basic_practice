public class CallByValueReferenceType2 {

  public static void main(String[] args) {
    // 과연 call by ref일까??
    AA aa = new AA("김갑환");
    run(aa);
    
    // 결과는??
    System.out.println(aa.name);
  }

  static void run(AA inputAA) {
    AA myAa = new AA("최번개");
    inputAA = myAa;
  }
}
class AA {
  String name;

  public AA(String name) {
    this.name = name;
  }
}