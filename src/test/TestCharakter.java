package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Charakter;
import model.Player;
import org.junit.jupiter.api.Test;

public class TestCharakter {


    @Test
    public void charaktersNameCanBeAskedAfter() {
        Charakter player = new Player("Duckoo");

        assertEquals(player.getName(), "Duckoo");
    }

    @Test
    public void charaktersNameCanBeSet() {
        Charakter player = new Player("Duckoo");

        player.setName("Linnea");

        assertEquals(player.getName().toString(), "Linnea");
    }
}
