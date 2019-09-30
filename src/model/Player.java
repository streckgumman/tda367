package model;

import java.awt.*;

public class Player extends Charakter {

    private boolean movingRight = false;
    private boolean movingLeft = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private Item    item;

    public Player(String name) {
        super(name, new Point(1920/2,1080/2));
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

    public Item getItem() {
        return item;
    }

    public void pickUpItem(Item item){
        if(this.item != null){
            this.item.drop();
        }
        this.item = item;
    }

}
