package model;

import java.awt.*;

/**
 * Represents the player that the user uses to play the game and can controll
 */
public class Player extends Charakter {

    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;

    public Player(String name) {
        super(name, new Point(1920 / 2, 1080 / 2));
    }

    @Override
    public void update() {
        int dx = 0;
        int dy = 0;
        if (movingRight) {
            dx += 10;
        }
        if (movingLeft) {
            dx -= 10;
        }
        if (movingUp) {
            dy -= 10;
        }
        if (movingDown) {
            dy += 10;
        }
        move(dx, dy);
    }

    public void move(int dx, int dy) {
        setPosition(getX() + dx, getY() + dy);
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }
}
