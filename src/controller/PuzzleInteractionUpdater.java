package controller;

import model.*;

import java.awt.event.KeyEvent;

public class PuzzleInteractionUpdater extends Updater<Player> {

    private Game game;
    private GameStateChanger stateChanger;

    protected PuzzleInteractionUpdater(Player gameObject, Game game, GameStateChanger stateChanger) {
        super(gameObject);
        this.game = game;
        this.stateChanger = stateChanger;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            if (game.getLevel().getCurrentPuzzle().checkIfDone(getGameObject())) {
                game.nextLevel();
                stateChanger.changeGameState();
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
