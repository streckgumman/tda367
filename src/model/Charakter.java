package model;

/**
 * Abstract class for any character in the game.
 *
 * Intentionally misspelled to not interfere with java's own Character class
 */
public abstract class Charakter extends GameObject {

    /**
     * The character's name
     */
    private String name;

    /**
     * Constructor
     *
     * @param name   the character's name
     * @param x      the character's initial x-position
     * @param y      the character's initial y-position
     * @param width  the character's width
     * @param height the character's height
     */
    public Charakter(String name, int x, int y, int width, int height, GameObjectType type) {
        super(x, y, width, height, type);
        this.name = name;
    }

    /**
     * Getter method for the character's name
     *
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the character's name
     *
     * @param name the character's new name
     */
    public void setName(String name) {
        this.name = name;
    }
}