package core_java.designPatterns.observer;

public interface Subject {

    void subscribe(Observer ob);
    void unsubscribe(Observer ob);

    void uploadNewVideo(String title);
}
