package core_java;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthHighestSalaryInterviewSolution {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("100", 1500);
        map.put("101", 2000);
        map.put("102", 1600);
        map.put("103", 2500);
        map.put("104", 1400);
        map.put("105", 1400);
        map.put("106", 1400);
        map.put("110", 2000);

        int n = 2;
        //getNthHighestSalary(map,n);

        Map.Entry<Integer, List<String>> entry = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(n - 1);


        System.out.println(entry.getKey()+" "+entry.getValue());


    }
}
