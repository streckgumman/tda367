package controller;

import model.*;

import java.awt.event.KeyEvent;

public class PuzzleInteractionUpdater extends Updater<Player> {

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
            if(game.getLevel().getCurrentPuzzle().checkIfDone(getGameObject()) && game.getLevel().areAllPuzzlesSolved()){
                game.nextLevel();
                mc.switchToNextLevelView(game.getCurrentLevelsNrInLine());
            }
            if(game.getLevel().getCurrentPuzzle().checkIfDone(getGameObject())){
                game.getLevel().startNextPuzzle();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }
}
