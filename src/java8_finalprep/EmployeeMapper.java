package java8_finalprep;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeMapper implements Function<Employee, String> {
    @Override
    public String apply(Employee employee) {
        return employee.getName();
    }

    public static void main(String[] args) {

        EmployeeMapper mapper = new EmployeeMapper();
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 5000),
                new Employee(2, "Bob", 6000),
                new Employee(3, "Bob", 7000),
                new Employee(4, "David", 6000),
                new Employee(5, "Bob", 9000)
        );

        List<String> collect = employees.stream().map(mapper).collect(Collectors.toList());
        System.out.println(collect);
    }
}
