package core_java;

import java.util.*;
import java.util.stream.Collectors;

public class NthHighestSalarySolution {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("Yami", 1500);
        map.put("Ishita", 2000);
        map.put("Gargi", 1200);
        map.put("Upasana", 1000);
        map.put("Chandini", 1400);
        map.put("Rani", 1500);
        map.put("Ellina", 1200);
        map.put("Lipsa", 1500);

        Map.Entry<Integer, List<String>> result = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(1);

        System.out.println(result);

        Map<String,Developer> devMap = new HashMap<>();
        devMap.put("100",new Developer("Janvi",1500,22));
        devMap.put("101",new Developer("Urmi",2000,26));
        devMap.put("102",new Developer("Kajol",2000,20));
        devMap.put("103",new Developer("Ankita",2000,22));
        devMap.put("104",new Developer("Trisha",1600,24));
        devMap.put("105",new Developer("Pritee",2500,20));
        devMap.put("106",new Developer("Bhavna",1400,25));
        devMap.put("107",new Developer("Riddhi",1400,25));
        devMap.put("110",new Developer("Heena",1400,25));

//        Map<Developer, List<String>> res = devMap.entrySet()
//                .stream()
//                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
//
//        System.out.println(res);

        Collection<Developer> developers = devMap.values();
        List<Developer> developersList = developers.stream().toList();
        System.out.println(developersList);

        List<Map.Entry<Integer, List<Developer>>> entryList = developersList.stream()
                .collect(Collectors.groupingBy(developer -> developer.getSalary(), Collectors.mapping(developer -> developer, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList();

        for(Map.Entry<Integer,List<Developer>> e : entryList){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println();

        int n= 2;
        Map.Entry<Integer, List<Developer>> secondHighestSalEmployeeList = developersList.stream()
                .collect(Collectors.groupingBy(developer -> developer.getSalary(), Collectors.mapping(developer -> developer, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(n - 1);

        System.out.println(secondHighestSalEmployeeList.getKey() + " " + secondHighestSalEmployeeList.getValue());

    }
}
