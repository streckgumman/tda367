package model;

import java.util.ArrayList;
import java.util.List;

public interface TextObservable {

    List<TextObserver> observers = new ArrayList<>();

    private void notifyAdd(Text text) {
        for (TextObserver observer : observers) {
            observer.actOnTextAdd(text);
        }
    }

    private void notifyRemove(Text text) {
        for (TextObserver observer : observers){
            observer.actOnTextRemove(text);
        }
    }

    public void addObserver(TextObserver observer);

    public void removeObserver(TextObserver observer);

}
