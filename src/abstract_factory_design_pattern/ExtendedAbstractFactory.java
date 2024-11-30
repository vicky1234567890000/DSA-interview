package abstract_factory_design_pattern;

public class ExtendedAbstractFactory extends EmployeeAbstractFactory{
    @Override
    public Employee getEmployee(String type) {
        if(type.equals("android-dev"))
            return new AndroidDeveloper();
        return new WebDeveloper();
    }
}
