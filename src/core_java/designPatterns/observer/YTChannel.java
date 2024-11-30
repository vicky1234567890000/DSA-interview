package core_java.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class YTChannel implements Subject{

    List<Observer> list = new ArrayList<>();
    @Override
    public void subscribe(Observer ob) {
        list.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        list.remove(ob);
    }

    @Override
    public void uploadNewVideo(String title) {
        for(Observer ob : list){
            ob.provideNotification(title);
        }
    }
}
