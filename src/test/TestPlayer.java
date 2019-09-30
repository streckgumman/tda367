package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Player;
import org.junit.jupiter.api.Test;

public class TestPlayer {

    private Player player = new Player("Linnea");


    @Test
    public void playerShouldHaveCorrectStartPosition(){
        Player player = new Player("Duckoo");

        assertEquals(player.getX(),1920 / 2);
        assertEquals(player.getY(), 1080 / 2);
    }

    @Test
    public void playerAreMovingTheDirectionThatAreSet(){
        player.setMovingRight(true);
        assertEquals(player.isMovingRight(), true);

        player.setMovingRight(false);
        assertEquals(player.isMovingRight(), false);

        player.setMovingLeft(true);
        assertEquals(player.isMovingLeft(), true);

        player.setMovingLeft(false);
        assertEquals(player.isMovingLeft(), false);

        player.setMovingUp(true);
        assertEquals(player.isMovingUp(), true);

        player.setMovingUp(false);
        assertEquals(player.isMovingUp(), false);

        player.setMovingDown(true);
        assertEquals(player.isMovingDown(), true);

        player.setMovingDown(false);
        assertEquals(player.isMovingDown(), false);

    }


    @Test
    public void testMove(){
        player.setPosition(0,0);
        assertEquals(player.getX(), 0);
        assertEquals(player.getY(), 0);

        player.move(10, 0);

        assertEquals(player.getY(), 0);
        assertEquals(player.getX(), 10);

        player.move(-10, 0);
        assertEquals(player.getX(), 0);
        assertEquals(player.getY(), 0);

        player.move(10,10);
        assertEquals(player.getX(), 10);
        assertEquals(player.getY(), 10);
    }
    



}
