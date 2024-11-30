package core_java;

import java.util.HashMap;

public class HashCodeAndEquals {
    public static void main(String[] args){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put("FB".hashCode(),1);
        map.put("Ea".hashCode(),2);
        System.out.println(map);
    }
}
