package model;

public interface TextObserver {
    void actOnTextAdd(Text text);
    void actOnTextRemove(Text text);
}
