package core_java.designPatterns.observer;

public class Subscriber implements Observer{
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public Subscriber(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void provideNotification(String title) {
        System.out.println("Hello "+ name+ ": " + title + " is released");
    }
}
