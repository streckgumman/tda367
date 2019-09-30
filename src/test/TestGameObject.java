package test;

import model.GameObject;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameObject {

    private GameObject gameObject = new Player("testLinnea");

    @Test
    public void pointShouldSetYPosition(){
        gameObject.setYPosition(200);
        assertEquals(gameObject.getY(), 200);
    }

    @Test
    public void pointShouldSetXPosition(){
        gameObject.setXPosition(300);
        assertEquals(gameObject.getX(), 300);
    }

    @Test
    public void pointShouldSetPosition(){
        gameObject.setPosition(400, 400);
        assertEquals(gameObject.getY(), 400);
        assertEquals(gameObject.getX(), 400);
    }

}
