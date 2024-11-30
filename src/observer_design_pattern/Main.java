package observer_design_pattern;

public class Main {
    public static void main(String[] args) {
        YouTubeChannel ytc = new YouTubeChannel();
        Subscriber s1 = new Subscriber("Mayuri");
        Subscriber s2 = new Subscriber("Upasana");

        ytc.subscribe(s1);
        ytc.subscribe(s2);

        ytc.uploadVideo();
    }
}
