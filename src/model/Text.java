package model;

/**
 * A class that contains a string, the type of text (used for determining which font and size to use), and a point (where to print the text).
 */
public class Text {

    private final String text;
    private final TextType type;
    private Point position;

    public Text(String text, TextType type, Point position) {
        this.text = text;
        this.type = type;
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public TextType getType() {
        return type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public enum TextType {
        DIALOGUE,
        INTERACTION_PROMPT
    }
}
