package abstract_factory_design_pattern;

public class EmployeeFactory {

    public static Employee getEmployeeInstance(String type){

        ExtendedAbstractFactory e = new ExtendedAbstractFactory();
        return e.getEmployee(type);
    }

}
