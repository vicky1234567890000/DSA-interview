package abstract_factory_design_pattern;

public class WebDeveloper implements Employee{
    @Override
    public String name() {
        return "WEB-DEVELOPER";
    }

    @Override
    public Integer salary() {
        return 200000;
    }
}
