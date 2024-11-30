package basic_java8;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map map1 = new HashMap<>();

        map1.put("abc",1);
        map1.computeIfAbsent("abc",k -> getAsciiValue(k));
        map1.computeIfAbsent("bcd",k->getAsciiValue(k));

        System.out.println(map1.get("abc"));
    }

    private static Object getAsciiValue(Object k) {
        return new Object();
    }
}
