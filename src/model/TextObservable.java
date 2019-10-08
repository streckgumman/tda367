package model;

import java.util.ArrayList;
import java.util.List;

public interface TextObservable {

    List<TextObserver> observers = new ArrayList<>();

    private void notify(String text) {
        for (TextObserver observer : observers) {
            observer.actOnText(text);
        }
    }

    public void addObserver(TextObserver observer);

    public void removeObserver(TextObserver observer);

}
