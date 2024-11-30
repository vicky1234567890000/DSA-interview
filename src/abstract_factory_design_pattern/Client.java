package abstract_factory_design_pattern;

public class Client {
    public static void main(String[] args) {
        Employee employeeInstance = EmployeeFactory.getEmployeeInstance("android-dev");
        System.out.println(employeeInstance.name());
        System.out.println(employeeInstance.salary());
    }
}
