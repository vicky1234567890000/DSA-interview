package java8_coding_interview_questions;

import core_java.Developer;

import java.util.*;

public class ThenComparingPractice {
    public static void main(String[] args) {
        Map<String, Developer> map = new HashMap<>();
        map.put("100",new Developer("Janvi",1500,22));
        map.put("101",new Developer("Urmi",2000,26));
        map.put("102",new Developer("Trisha",1500,24));
        map.put("103",new Developer("Pritee",2500,20));
        map.put("104",new Developer("Bhavna",1400,25));
        map.put("105",new Developer("Riddhi",1400,25));
        map.put("106",new Developer("Heena",1400,25));

        Comparator<Map.Entry<String,Developer>> nameComp = Comparator.comparing(e -> e.getValue().getName());
        Comparator<Map.Entry<String,Developer>> salComp = Collections.reverseOrder(Comparator.comparing(e -> e.getValue().getSalary()));
        List<Map.Entry<String, Developer>> entries = map.entrySet()
                .stream()
                .sorted(salComp.thenComparing(nameComp))
                .toList();

//        for(Map.Entry<String, Developer> entry : entries){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

        List<Developer> devList = List.of(new Developer("Janvi",1500,22),
                new Developer("Urmi",2000,26),
                new Developer("Trisha",1500,24),
                new Developer("Pritee",2500,20),
                new Developer("Bhavna",1400,25),
                new Developer("Riddhi",1400,25),
                new Developer("Heena",1400,25));

        List<Developer> sortedDevList = devList.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Developer::getSalary)).thenComparing(Developer::getName))
                .toList();
        System.out.println(sortedDevList);

    }
}
