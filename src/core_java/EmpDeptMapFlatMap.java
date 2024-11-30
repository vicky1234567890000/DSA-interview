package core_java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpDeptMapFlatMap {

    public static void main(String[] args) {
        Department d1 = new Department(1, "SD",
                List.of(new Employee(100, "Aditi", 1000),
                        new Employee(101, "Jasmin", 2000),
                        new Employee(103, "Rani", 1500),
                        new Employee(104, "Rani", 2000)));

        Department d2 = new Department(2, "ST",
                List.of(new Employee(105, "Nilesh", 1500),
                        new Employee(106, "Bhabani", 3000),
                        new Employee(107, "Dipak", 1200),
                        new Employee(108, "Vicky", 7000)));

        Department d3 = new Department(3, "Infra",
                List.of(new Employee(109, "Tanya", 7000),
                        new Employee(110, "Simar", 500),
                        new Employee(111, "Rita", 400),
                        new Employee(112, "Ankita", 7000)));

        List<Employee> employeeList = Stream.of(d1, d2, d3)
                //.filter(dept -> dept.getDeptId() == 1)
                .flatMap(department -> department.getEmployees().stream())
                .toList();
        System.out.println(employeeList);

        Map.Entry<Integer, List<Employee>> maxSalEmployees = Stream.of(d1, d2, d3)
                //.filter(dept -> dept.getDeptId() == 2)
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(e -> e.getSalary(), Collectors.mapping(Function.identity(), Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(0);

        System.out.println(maxSalEmployees.getKey() + " " + maxSalEmployees.getValue());
    }
}
