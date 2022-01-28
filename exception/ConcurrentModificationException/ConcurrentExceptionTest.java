package example;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentExceptionTest {

    private static List<String> basicList = new ArrayList<>();
    private static List<String> copyList = new CopyOnWriteArrayList<>();
    private static Set<String> basicSet = new HashSet<>();
    private static Set<String> copySet = new ConcurrentSkipListSet<>();

    public static void main(String[] args) {
        setList(basicList);

        try {
            removeBasicList();
        } catch (ConcurrentModificationException e) {
            System.out.println("예외 발생");
        }

        setList(basicList);

        removeItrBasicList2();

        setList(basicList);

        removeItrBasicList1();

        setList(copyList);

        removeCopyList();

    }

    public static void removeBasicList() {
        for (String num : basicList) {
            if (Integer.parseInt(num) % 2 == 0) {
                basicList.remove(num);
            }
        }
    }

    // removeIf
    public static void removeItrBasicList1() {
        basicList.removeIf(num -> Integer.parseInt(num) % 2 == 0);
    }

    // itr
    // 내 ide는 removeIf 사용을 권장한다고 말해준다.
    public static void removeItrBasicList2() {
        for (Iterator<String> itr = basicList.iterator(); itr.hasNext(); ) {
            String now = itr.next();
            if (Integer.parseInt(now) % 2 == 0) {
                itr.remove(); // right call
            }
        }
    }

    public static void removeCopyList() {
        for (String num : copyList) {
            if (Integer.parseInt(num) % 2 == 0) {
                copyList.remove(num);
            }
        }
    }

    public static void setList(List<String> list) {
        for (int i = 1; i < 30; i++) {
            list.add(i + "");
        }
    }
}
