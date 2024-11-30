package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {

    List<Observer> obs = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {

        obs.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {

        obs.remove(ob);
    }

    @Override
    public void uploadVideo() {
        for(Observer ob : obs){
            ob.notified();
        }
    }
}
