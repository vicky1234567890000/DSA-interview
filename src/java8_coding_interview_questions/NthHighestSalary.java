package java8_coding_interview_questions;

import core_java.Developer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NthHighestSalary {
    public static void main(String[] args) {
        Map<String, Developer> devMap = new HashMap<>();
        devMap.put("100", new Developer("Janvi", 1500, 22));
        devMap.put("101", new Developer("Urmi", 2000, 26));
        devMap.put("102", new Developer("Kajol", 2000, 20));
        devMap.put("103", new Developer("Ankita", 2000, 22));
        devMap.put("104", new Developer("Trisha", 1600, 24));
        devMap.put("105", new Developer("Pritee", 2500, 20));
        devMap.put("106", new Developer("Bhavna", 1400, 25));
        devMap.put("107", new Developer("Riddhi", 1400, 25));
        devMap.put("110", new Developer("Heena", 1400, 25));
        int n = 2;
        Map.Entry<Integer, List<String>> nthHighestSalary = devMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getValue().getSalary(), Collectors.mapping(e->e.getValue().getName(), Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(n - 1);

        System.out.println(nthHighestSalary.getKey() + " " + nthHighestSalary.getValue());

//        List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
//         Set<String> set = people.stream().map(Person::getName)    .collect(Collectors.toCollection(TreeSet::new));    // Convert elements to strings and concatenate them, separated by commas  String joined = things.stream()    .map(Object::toString)    .collect(Collectors.joining(", "));    // Compute sum of salaries of employee  int total = employees.stream()    .collect(Collectors.summingInt(Employee::getSalary));    // Group employees by department  Map<Department, List<Employee>> byDept = employees.stream()    .collect(Collectors.groupingBy(Employee::getDepartment));    // Compute sum of salaries by department  Map<Department, Integer> totalByDept = employees.stream()    .collect(Collectors.groupingBy(Employee::getDepartment,                                   Collectors.summingInt(Employee::getSalary)));    // Partition students into passing and failing  Map<Boolean, List<Student>> passingFailing = students.stream()    .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
    }
}
