package inter.exam2;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    DBService service = new DBService();
    service.setDAO(new OracleDAO());
    service.setDAO(new MysqlDAO());
    service.connect();
  }
}

// 인터페이스 사용 이유


// 1. 객체를 외부관점에서 단순화 시킨다.
// 클래스들 간의 의존성을 감소시키는 용도로도 사용이 된다.

// 2. 비슷한 객체를 군집화시킨다.
// 메소드 강제