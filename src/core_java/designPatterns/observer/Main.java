package core_java.designPatterns.observer;

public class Main {
    public static void main(String[] args) {
        YTChannel channel = new YTChannel();

        Subscriber abhisek = new Subscriber("abhisek");
        Subscriber modi = new Subscriber("modi");

        channel.subscribe(abhisek);
        channel.subscribe(modi);

        channel.uploadNewVideo("India t20 victory");
        channel.uploadNewVideo("Roko speech");


    }
}
