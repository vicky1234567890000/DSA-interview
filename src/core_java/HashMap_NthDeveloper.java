package core_java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMap_NthDeveloper {

    public static void main(String[] args){
        Map<String,Developer> map = new HashMap<>();
        map.put("100",new Developer("Janvi",1500,22));
        map.put("101",new Developer("Urmi",2000,26));
        map.put("102",new Developer("Trisha",1600,24));
        map.put("103",new Developer("Pritee",2500,20));
        map.put("104",new Developer("Bhavna",1400,25));
        map.put("105",new Developer("Riddhi",1400,25));
        map.put("106",new Developer("Heena",1400,25));

        List<Developer> developers = map.entrySet().stream().
                map((developerEntry -> developerEntry.getValue())).collect(Collectors.toList());

        Comparator<Developer> developerComparator = (Developer d1, Developer d2) -> d1.getSalary().compareTo(d2.getSalary());

        Comparator<Developer> developerComparatorName = (d1,d2) -> d1.getName().compareTo(d2.getName());

        List<Map.Entry<String, Developer>> entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((d1, d2) -> d1.getSalary().compareTo(d2.getSalary())))
                .toList();

        List<Map.Entry<String, Developer>> entriesReversedAlternative = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Developer::getSalary).reversed()))
                .toList();

       // Comparator<Map.Entry<Object, Developer>> entryComparatorForSalName = Map.Entry.comparingByValue(developerComparator.reversed().thenComparing(developerComparatorName));
       Comparator<Developer> developerComparatorReversedSalName = developerComparator.reversed().thenComparing(developerComparatorName);
        List<Map.Entry<String, Developer>> entriesReversed = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(developerComparatorReversedSalName))
                .toList();

        for(Map.Entry<String,Developer> e : entries){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println();
        System.out.println();

        for(Map.Entry<String,Developer> e : entriesReversed){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println();
        System.out.println();

        for(Map.Entry<String,Developer> e : entriesReversedAlternative){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        //System.out.println(developers);
    }
}
