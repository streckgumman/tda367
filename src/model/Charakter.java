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
     * @param name  the character's name
     * @param point the character's initial position
     */

    public Charakter(String name, Point point, int width, int height) {

        super(point, width, height);
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
    public void setName (String name){
        this.name = name;
    }
}