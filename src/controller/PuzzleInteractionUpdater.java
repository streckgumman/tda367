package controller;

import model.*;

import java.awt.event.KeyEvent;

public class PuzzleInteractionUpdater extends Updater <Player>{

    private Game game;
    private MainController mc;

    protected PuzzleInteractionUpdater(Player gameObject, Game game, MainController mc) {
        super(gameObject);
        this.game = game;
        this.mc = mc;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            Puzzle puzzle = game.getLevel().getPuzzles().get(0);
            if (IntersectionDetector.intersects(getGameObject().getHitbox(), puzzle.getHitbox())){
                if(checkIfHoldingKey()){
                    game.nextLevel();
                    mc.switchToNextLevelView(game.getCurrentLevelsNrInLine());
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
