package core_java;

import java.util.Objects;

public class Employee {

    private int empId;
    private String empName;

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Employee(int empId, String empName, Integer salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getSalary().equals(employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId(), getEmpName(), getSalary());
    }
}
