package model;

public interface TextObservable {

    public void notifyAdd(Text text);

    public void notifyRemove(Text text);

    public void addObserver(TextObserver observer);

    public void removeObserver(TextObserver observer);

}
