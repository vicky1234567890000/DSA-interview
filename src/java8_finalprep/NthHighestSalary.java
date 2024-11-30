package java8_finalprep;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    Integer id;
    String name;
    Integer salary;

    public Employee(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class NthHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 5000),
                new Employee(2, "Bob", 6000),
                new Employee(3, "Bob", 7000),
                new Employee(4, "David", 6000),
                new Employee(5, "Bob", 9000)
        );

        int n = 2; // Find the 2nd highest salary employees

        // Find the nth highest salary
        List<Integer> uniqueSalaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (n > uniqueSalaries.size()) {
            System.out.println("The list doesn't have " + n + " different salary levels.");
            return;
        }

        int nthHighestSalary = uniqueSalaries.get(n - 1);

        // Filter employees with the nth highest salary
        List<Employee> nthHighestSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary().equals(nthHighestSalary))
                .collect(Collectors.toList());

        System.out.println(n + "th highest salary employees: " + nthHighestSalaryEmployees);


        // avg salary of employees whose names are Bob.

        int sum = employees.stream()
                .filter(e -> e.getName().equals("Bob"))
                .map(Employee::getSalary)
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);

        double average = employees.stream()
                .filter(e -> e.getName().equals("Bob"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(average);
    }
}

