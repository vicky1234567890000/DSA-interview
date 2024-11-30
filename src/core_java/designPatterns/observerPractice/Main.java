package core_java.designPatterns.observerPractice;

public class Main {

    public static void main(String[] args) {
        Subscriber abhisek = new Subscriber("abhisek");
        Subscriber rahul = new Subscriber("rahul");

        YTChannel cricbuzz = new YTChannel();
        cricbuzz.subscribe(abhisek);
        cricbuzz.subscribe(rahul);

        cricbuzz.uploadNewVideo("India WC victory");
    }
}
