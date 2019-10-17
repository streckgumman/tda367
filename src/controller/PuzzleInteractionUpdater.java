package controller;

import model.*;

import java.awt.event.KeyEvent;

/**
 * @author Johannes Kvernes
 * @author Linnea Johansson
 * @author Amanda Dehlén
 *
 * A class that updates the level when you solve a puzzle
 */
public class PuzzleInteractionUpdater extends Updater<Player> {

    private Game game;
    private GameStateChanger stateChanger;

    /**
     * The public constructor for the class PuzzleInteractionUpdater
     *
     * The class PuzzleInteractionUpdater extends the class Updater<Player>
     *
     * @param gameObject the player the user controls
     * @param game the game
     * @param stateChanger the statechanger that shows the game we should change level
     */
    protected PuzzleInteractionUpdater(Player gameObject, Game game, GameStateChanger stateChanger) {
        super(gameObject);
        this.game = game;
        this.stateChanger = stateChanger;
    }

    /**
     * A method to check if the game should change level when the player presses 'E'
     * If the current puzzle gets solved and all other puzzles of the level are done, the game should change level
     *
     * If current puzzle is solved but not all puzzles are solved, the next puzzle should start
     *
     * @param event the keyevent, the method checks if the user presses 'E'
     */
    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_E) {
            if (game.getLevel().getCurrentPuzzle().checkIfDone(getGameObject())) {
                if (game.getLevel().areAllPuzzlesSolved()) {
                    game.nextLevel();
                    stateChanger.changeGameState();
                } else {
                    game.getLevel().startNextPuzzle();
                }
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
