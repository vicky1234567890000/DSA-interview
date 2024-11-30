package observer_design_pattern;

public interface Subject {

    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    void uploadVideo();
}
