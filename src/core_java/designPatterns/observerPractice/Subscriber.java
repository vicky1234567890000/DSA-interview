package core_java.designPatterns.observerPractice;

public class Subscriber implements Observer{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subscriber(String name) {
        this.name = name;
    }

    public Subscriber() {
    }

    @Override
    public void provideNotification(String title) {
        System.out.println("Hello " + name + " : " + title + " is released");
    }
}
