package core_java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThenComparingPractice {

    public static void main(String[] args) {
        Map<String, Developer> map = new HashMap<>();
        map.put("100", new Developer("Ananya", 2000, 22));
        map.put("101", new Developer("Upasana", 2000, 26));
        map.put("102", new Developer("Trisha", 1600, 24));
        map.put("103", new Developer("Pritee", 2500, 20));
        map.put("104", new Developer("Bhavna", 1400, 25));
        map.put("105", new Developer("Tanaya", 2000, 25));
        map.put("106", new Developer("Heena", 1400, 25));

        Comparator<Developer> salComp = Comparator.comparing(Developer::getSalary);
        Comparator<Developer> revSalComp = salComp.reversed();

        Comparator<Developer> nameComp = (d1, d2) -> d1.getName().compareTo(d2.getName());

        Map.Entry<Integer, List<Developer>> entry = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(revSalComp.thenComparing(nameComp)))
                .collect(Collectors.groupingBy(e -> e.getValue().getSalary(), Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .entrySet()
                .stream()
                .toList()
                .get(1);
        ;

        System.out.println(entry.getKey() + " ---------- " + entry.getValue());


        List<Map.Entry<String, Developer>> entries =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(revSalComp.thenComparing(nameComp)))
                        .toList();

        List<Map.Entry<String, Developer>> entriesAlt =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Developer::getSalary).reversed().thenComparing(Developer::getName)))
                        .toList();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Developer::getSalary).reversed().thenComparing(Developer::getName)))
                .toList();

        for (Map.Entry<String, Developer> e : entries) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println();

        for (Map.Entry<String, Developer> e : entriesAlt) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }
}
