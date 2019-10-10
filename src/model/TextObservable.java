package model;

import java.util.ArrayList;
import java.util.List;

public interface TextObservable {

    List<TextObserver> observers = new ArrayList<>();

    public void notifyAdd(Text text);

    public void notifyRemove(Text text);

    public void addObserver(TextObserver observer);

    public void removeObserver(TextObserver observer);

}
