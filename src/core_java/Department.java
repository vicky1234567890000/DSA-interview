package core_java;

import java.util.List;

public class Department {
    private int deptId;
    private String deptName;

    private List<Employee> employees;

    public Department(int deptId, String deptName, List<Employee> employees) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employees = employees;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
