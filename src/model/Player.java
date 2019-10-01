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
    private Item    item;


    public Player(String name) {
        super(name, new Point(1920 / 2, 1080 / 2), 804/4, 1074/4);
    }

    @Override
    public void update() {
        int dx = 0;
        int dy = 0;
        if (movingRight && getX() < 1920 - 300) {
            dx += 10;
        }
        if (movingLeft && getX() > 0) {
            dx -= 10;
        }
        if (movingUp && getY() > 0) {
            dy -= 10;
        }
        if (movingDown && getY() < 1080 - 250) {
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

    public Item getItem() {
        return item;
    }
    public boolean isMovingRight() {
        return movingRight;
    }

    public void pickUpItem(Item item){
        if(this.item != null){
            this.item.drop();
        }
        this.item = item;
    }
    public boolean isMovingLeft() {
        return movingLeft;
    }

    public boolean isMovingUp(){ return movingUp;}

    public boolean isMovingDown(){return movingDown;}

}
