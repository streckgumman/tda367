package model;

/**
 * GameObject represent a object that can exist in the game
 *
 * @author Amanda Dehlén, Linnea Johansson, Anna Nilsson
 * @since 2019-10-01
 */
public abstract class GameObject implements HitboxOwner, TextObservable {

    private Hitbox hitbox;

    public GameObject(int x, int y, int width, int height) {
        this.hitbox = new Hitbox(x, y, width, height);
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

    protected abstract void update();

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public void addObserver(TextObserver observer) {
        observers.remove(observer);
    }

    public void removeObserver(TextObserver observer) {
        observers.add(observer);
    }

    public void notifyAdd(Text text) {
        for (TextObserver observer : observers) {
            observer.actOnTextAdd(text);
        }
    }

    public void notifyRemove(Text text) {
        for (TextObserver observer : observers) {
            observer.actOnTextRemove(text);
        }
    }
}
