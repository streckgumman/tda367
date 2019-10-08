package controller;

import model.*;

import java.awt.event.KeyEvent;

public class PuzzleInteractionUpdater extends Updater <Player>{

    private Game game;

    protected PuzzleInteractionUpdater(Player gameObject, Game game) {
        super(gameObject);
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            Puzzle puzzle = game.getLevel().getPuzzles().get(0);
            if (IntersectionDetector.intersects(getGameObject().getHitbox(), puzzle.getHitbox())){
                if(checkIfHoldingKey()){
                    game.nextLevel();
                }
            }
        }
    }

    private boolean checkIfHoldingKey(){
        if(getGameObject().getItem() != null) {
            return (getGameObject().getItem().getType() == ItemType.KEY);
        }
        return false;
    }


    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }
}
