package java8_coding_interview_questions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary_1 {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Ankita",100);
        map.put("Upasana",100);
        map.put("Reema",200);
        map.put("Tanaya",50);
int n = 2;
        Map.Entry<Integer, List<String>> secondHighestSalary = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(n - 1);
        System.out.println(secondHighestSalary.getKey() + " " + secondHighestSalary.getValue());
    }
}
