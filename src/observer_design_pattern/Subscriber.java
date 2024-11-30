package observer_design_pattern;

public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notified() {
        System.out.println("Notification sent to subscriber : " + this.name);
    }
}
