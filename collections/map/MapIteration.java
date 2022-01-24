package example;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {
    public static void main(String[] args) {

        //"entrySet()" should be iterated when both the key and value are needed

        //When only the keys from a map are needed in a loop, iterating the keySet makes sense. But when both the key and the value are needed,
        // it’s more efficient to iterate the entrySet, which will give access to both the key and value, instead.
        //Noncompliant Code Example
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
        }
    }

    // key and value
    public void doSomethingWithMapBoth(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            // ...
        }
    }

    // value
    public void doSomethingWithMapValue(Map<String, Integer> map) {
        for (Integer values : map.values()) {
            // values 사용
        }
    }

    static Map<String, Integer> hs = new HashMap<>();

    static int res2 = 0;
    static int res3 = 0;
    static int res1 = 0;

    // key,value 모두 사용하는 잘못된 반복
    static void hashLoopNonCompliant() {
        for (String keys : hs.keySet()) {
            res1 += hs.get(keys);
        }
    }

    // key,value 모두 사용하는 옳은 반복
    static void hashLoopCompliant() {
        for (Map.Entry<String, Integer> entry : hs.entrySet()) {
            res2 += entry.getValue();
        }
    }

    // value 만 사용하는 반복
    static void hashLoopValues() {
        for (Integer values : hs.values()) {
            res3 += values;
        }
    }

    //Declarations should use Java collection interfaces
    // such as "List" rather than specific implementation classes such as "LinkedList"

    // Noncompliant
    private HashMap<Object, Object> nonCompliantMap = new HashMap<>();
    // Compliant
    private HashMap<Object, Object> compliantMap = new HashMap<>();
}
