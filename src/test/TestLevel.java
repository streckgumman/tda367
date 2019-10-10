package test;

import model.Level;
import model.NPC;
import model.Puzzle;
import model.items.Key;
import model.items.Scissors;
import model.npcs.DogWithGun;
import model.npcs.TestNPC;
import model.puzzles.Door;
import model.puzzles.TestPuzzle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Linnea Johansson, Amanda Dehlén
 *
 * A class to test the Level class
 */

public class TestLevel {

    private Level testLevel;

    /**
     * Should return all items that the level carries
     */

    @Test
    public void shouldGetAllItemsFromItemList(){
        testLevel = new model.levels.TestLevel(0);
        Key testItem = new Key(10, 10);
        Scissors testItem2 = new Scissors("sax", 2, 15);
        testLevel.addItem(testItem);
        testLevel.addItem(testItem2);
        assertEquals(testItem, testLevel.getItems().get(0));
        assertEquals(testItem2, testLevel.getItems().get(1));
        assertEquals(2, testLevel.getItems().size());
    }

    /**
     * Should add items to Level's item list
     */

    @Test
    public void shouldAddItemToItemList(){
        testLevel = new model.levels.TestLevel(0);
        Key testItem = new Key(10, 10);
        testLevel.addItem(testItem);
        assertEquals(testItem, testLevel.getItems().get(0));
    }

    /**
     * Should return all NPCs that the level carries
     */

    @Test
    public void shouldGetAllNPCsFromNPCList(){
        testLevel = new model.levels.TestLevel(0);
        NPC testNPC = new DogWithGun("TestNPC1");
        NPC testNPC2 = new TestNPC("TestNPC2");
        testLevel.addNPC(testNPC);
        testLevel.addNPC(testNPC2);
        assertEquals(testNPC, testLevel.getNpcs().get(0));
        assertEquals(testNPC2, testLevel.getNpcs().get(1));
        assertEquals(2, testLevel.getNpcs().size());
    }

    /**
     * Should add NPCs to the level's NPC list
     */

    @Test
    public void shouldAddNPCToNPCList(){
        testLevel = new model.levels.TestLevel(0);
        NPC testNPC = new DogWithGun("Doggo");
        testLevel.addNPC(testNPC);
        assertEquals(testNPC, testLevel.getNpcs().get(0));
    }

    /**
     * Should return all puzzles from the level's puzzle list
     */

    @Test
    public void shouldGetAllPuzzlesFromPuzzleList(){
        testLevel = new model.levels.TestLevel(0);
        Puzzle testPuzzle = new Door(10, 10, 10, 10);
        Puzzle testPuzzle2 = new TestPuzzle(10, 10, 10, 10);
        testLevel.addPuzzle(testPuzzle);
        testLevel.addPuzzle(testPuzzle2);
        assertEquals(testPuzzle, testLevel.getPuzzles().get(0));
        assertEquals(testPuzzle2, testLevel.getPuzzles().get(1));
        assertEquals(2, testLevel.getPuzzles().size());
    }

    /**
     * Should add puzzles to Levels's Puzzle list
     */

    @Test
    public void shouldAddPuzzlesToPuzzleList(){
        testLevel = new model.levels.TestLevel(0);
        Puzzle testPuzzle = new Door(10, 10, 10, 10);
        testLevel.addPuzzle(testPuzzle);
        assertEquals(testPuzzle, testLevel.getPuzzles());
    }

}
