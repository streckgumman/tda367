package model;

import java.util.ArrayList;
import java.util.List;

/**
 * GameObject represent a object that can exist in the game
 *
 * @author Amanda Dehlén
 * @author Samuel Widén
 * @author Linnea Johansson
 * @author Johannes Kvernes
 * @author Anna Nilson
 * @since 2019-10-01
 */
public abstract class GameObject implements HitboxOwner, TextObservable {

    protected GameObjectType type;
    private Hitbox hitbox;
    private List<TextObserver> observers = new ArrayList<>();
    private Text lastInteractionPrompt;

    private boolean interactionPrompted;


    /**
     * The public constructor for the class GameObject
     *
     * @param x      the position of the GameObject in x axis
     * @param y      the position of the GameObject in y axis
     * @param width  the width of the GameObject's hitbox
     * @param height the height of the GameObject's hitbox
     */
    public GameObject(int x, int y, int width, int height, GameObjectType type) {
        this.hitbox = new Hitbox(x, y, width, height);
        this.type = type;
        interactionPrompted = false;
    }

    /**
     * Sets the position of the GameObject to the x and y coordinates
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setPosition(int x, int y) {
        setXPosition(x);
        setYPosition(y);
    }

    /**
     * Sets the position of the GameObject to the x coordinate and the original y coordinate
     *
     * @param x the x coordinate
     */
    public void setXPosition(int x) {
        hitbox.setX(x);
    }

    /**
     * Sets the position of the GameObject to the y coordinate and the original x coordinate
     *
     * @param y the y coordinate
     */
    public void setYPosition(int y) {
        hitbox.setY(y);
    }

    public int getX() {
        return hitbox.getX();
    }

    public int getY() {
        return hitbox.getY();
    }

    public int getWidth() {
        return hitbox.getWidth();
    }

    public int getHeight() {
        return hitbox.getHeight();
    }

    public boolean isInteractionPrompted() {
        return interactionPrompted;
    }

    public void setInteractionPrompted(boolean interactionPrompted) {
        this.interactionPrompted = interactionPrompted;
    }

    /**
     * The abstract protected method that is implemented in subclasses
     */
    // Is not fully implemented in subclasses
    //Should be moved to it's own class or interface
    protected abstract void update();

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public GameObjectType getType() {
        return type;
    }

    public void addObserver(TextObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TextObserver observer) {
        observers.remove(observer);
    }

    /**
     * Calls the Observers' methods for adding text.
     * @param text The text to be acted upon.
     */
    public void notifyAdd(Text text) {
        stopShowingInteractionPrompt();
        lastInteractionPrompt = text;
        for (TextObserver observer : observers) {
            observer.actOnTextAdd(text);
        }
    }

    public void notifyRemove(Text text) {
        for (TextObserver observer : observers) {
            observer.actOnTextRemove(text);
        }
    }

    public void stopShowingInteractionPrompt() {
        notifyRemove(lastInteractionPrompt);
    }

    /**
     * Details what should be done when a GameObject intersects the player @TODO Method name is not very extensible
     */
    public abstract void promptInteraction();

}
