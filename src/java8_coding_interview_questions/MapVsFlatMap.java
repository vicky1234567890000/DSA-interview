package java8_coding_interview_questions;

import core_java.Developer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        Dept d1 = new Dept(1, List.of(new Developer("Janvi",1500,22),
                new Developer("Urmi",2000,26)));

        Dept d2 = new Dept(2,List.of(new Developer("Trisha",1500,24),
                new Developer("Pritee",2500,20),
                new Developer("Bhavna",1400,25)));

        Dept d3 = new Dept(3,List.of(new Developer("Riddhi",1400,25),
                new Developer("Heena",1400,25)));

        List<Dept> depts = List.of(d1, d2, d3);

        List<String> devList = depts.stream()
                .flatMap(d -> d.getDeveloperList().stream().map(dev -> dev.getName()))
                .toList();
        System.out.println(devList);


//        Map<List<Developer>, Long> collect = depts.stream()
//                .collect(Collectors.groupingBy(d -> d.getDeveloperList(), Collectors.counting()));
//
//        System.out.println(listMap);

    }
}
