package w3;

import java.sql.SQLException;
import java.util.List;

public class UncheckedExceptionExam {
    public static void main(String[] args) {
        PDS pds = new PDS();
        List<String> girlFriendList = pds.getGirlFriendList();
//        System.out.println(girlFriendList.get(0));
        try {
            pds.run();
        } catch (CustomException throwables) {
            throwables.printStackTrace();
        }
//        pds.run2();
        pds.run5();
    }
}

class PDS {
    List<String> getGirlFriendList() {
        return null;
    }

    void run() {
        if (1 == 1) {
            CustomException customException = new CustomException("커스텀예외");
            customException.initCause(new SQLException());
            throw  customException;
        }
    }

    void run2() {
        if (1 == 1) {
            throw new NullPointerException();
        }
    }

    void run3() throws CheckedException {
        if (1 == 1) {
            throw new CheckedException("컴파일 예외");
        }
    }

    void run4() {
        if (1 == 1) {
            throw new UncheckedException("런타임 예외");
        }
    }

    void run5() {
        if (1 == 1) {
            throw new RuntimeException(new CheckedException("컴파일 예외"));
        }
    }
}

class CustomException extends RuntimeException {

    public CustomException(Throwable cause) {
        super(cause);
    }
    public CustomException(String msg){
        super(msg);
    }
}

class CheckedException extends Exception {
    public CheckedException(String msg) {
        super(msg);
    }
}

class UncheckedException extends RuntimeException {
    public UncheckedException(String msg) {
        super(msg);
    }
}