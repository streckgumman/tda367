package test;

import model.Game;
import model.Level;
import model.Player;
import model.levels.Level1;
import model.levels.Level2;
import model.levels.Level3;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Linnea Johansson
 *
 * Class to test the Game Class
 */

public class TestGame {

    Game game;


    /**
     * Testing if the game knows to go to next level
     * In Game class, Level1, Level2 and Level3 is currently initialized
     * Tests that the current level is not the same as the last level
     */
    @Test
    public void shouldGoToNextLevel(){
        game = new Game();
        Level testLevel1 = game.getLevel();
        game.nextLevel();
        assertFalse(testLevel1 == game.getLevel());
        Level testLevel2 = game.getLevel();
        game.nextLevel();
        assertFalse(testLevel1 == testLevel2);
        assertFalse(testLevel2 == game.getLevel());
    }

}
