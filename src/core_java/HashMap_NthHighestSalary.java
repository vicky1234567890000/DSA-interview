package core_java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMap_NthHighestSalary {

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();

        map.put("Yami",1500);
        map.put("Ishita",2000);
        map.put("Gargi",1200);
        map.put("Upasana",1000);
        map.put("Chandini",1400);

        Map.Entry<String, Integer> secondHighestSalary = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList()
                .get(1);

        System.out.println(secondHighestSalary.getKey() + " " + secondHighestSalary.getValue());

    }
}
