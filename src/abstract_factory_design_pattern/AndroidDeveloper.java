package abstract_factory_design_pattern;

public class AndroidDeveloper implements Employee{
    @Override
    public String name() {
        return "ANDROID-DEVELOPER";
    }

    @Override
    public Integer salary() {
        return 100000;
    }
}
