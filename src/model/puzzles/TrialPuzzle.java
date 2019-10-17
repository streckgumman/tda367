package model.puzzles;

import model.Item;
import model.Player;
import model.Puzzle;

public class TrialPuzzle extends Puzzle {

    public TrialPuzzle(int x, int y, int width, int height) {
        super(x, y, width, height, null);

    }

    protected void update() {

    }

    protected boolean checkIfHoldingItem(Player player) {
        return false;
    }

    protected Item getMyItem() {
        return null;
    }
}
