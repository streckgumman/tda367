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
    public void playersNameCanBeAskedAfter(){
        
    }

    @Test
    public void playerShouldMoveRight(){







    }


}
