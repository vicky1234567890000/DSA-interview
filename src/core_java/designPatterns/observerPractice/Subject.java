package core_java.designPatterns.observerPractice;

public interface Subject {

    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    void uploadNewVideo(String title);

}
