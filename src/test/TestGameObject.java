package test;

import model.GameObject;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 * TestClass that tests the methods in the class GameObject
 *
 */

public class TestGameObject {

    private GameObject gameObject = new Player("testLinnea");

    /**
     * Tests the method setYPosition in GameObject
     * Sets the gameobjects position in y axis and asserts that it is set in the right way
     */
    @Test
    public void pointShouldSetYPosition(){
        gameObject.setYPosition(200);
        assertEquals(gameObject.getY(), 200);
    }
    /**
     * Tests the method setXPosition in GameObject
     * Sets the gameobjects position in x axis and asserts that it is set in the right way
     */
    @Test
    public void pointShouldSetXPosition(){
        gameObject.setXPosition(300);
        assertEquals(gameObject.getX(), 300);
    }

    /**
     * Tests the method setPosition in GameObject
     * Sets the gameobjects position in both y and x axis and asserts that it is set in the right way
     */
    @Test
    public void pointShouldSetPosition(){
        gameObject.setPosition(400, 400);
        assertEquals(gameObject.getY(), 400);
        assertEquals(gameObject.getX(), 400);
    }

}
