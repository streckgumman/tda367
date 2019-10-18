package controller;

import model.Game;
import model.IntersectionDetector;
import model.Level;
import view.InGameView;
import view.View;

import java.awt.event.KeyEvent;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 * @author Anna Nilsson
 * <p>
 * The in game controller that updates the model while playing.
 */
public class InGameController extends Controller {

    private boolean paused = false;
    PauseMenuUpdater pauseMenuUpdater;

    /**
     * Constructor
     *
     * @param view             The current view of the game
     * @param game             The game object containing the state of game
     * @param gameExiter       interface with method to exit the game
     * @param nextLevelChanger interface with method to change the level
     */
    @SuppressWarnings("unchecked")

    public InGameController(View view, Game game, GameExiter gameExiter, GameStateChanger nextLevelChanger) {
        super(view, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
        addUpdater(new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    pause();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {

            }
        });

        addUpdater(new ItemInteractionUpdater(game.getPlayer(), game));
        addUpdater(new NPCInteractionUpdater(game.getPlayer(), game));
        addUpdater(new PuzzleInteractionUpdater(game.getPlayer(), game, nextLevelChanger));
        pauseMenuUpdater = new PauseMenuUpdater(this::play, gameExiter, (InGameView) getView());
    }

    /**
     * A method that updates the model
     * through the game's player.
     */
    protected void updateModel() {
        if (!paused) {
            game.getPlayer().update();
        }
    }

    /**
     * Pauses the InGameView when
     * the pause menu is active
     */
    public void pause() {
        paused = true;
        ((InGameView) getView()).setPaused(true);
        pauseMenuUpdater.alreadyClicked = true;
    }

    /**
     * Starts the game after the
     * pause menu has been inactivated
     */
    public void play() {
        paused = false;
        ((InGameView) getView()).setPaused(false);
    }

    /**
     * If the game is not paused
     * opens the pause menu
     *
     * @param event
     */
    @Override
    public void keyPressed(KeyEvent event) {
        if (!paused) {
            super.keyPressed(event);
        } else {
            pauseMenuUpdater.keyPressed(event);
        }
    }


    // When the player holds in a key and then press escape
    //the player will never reach the keyReleased method.
    //This means if the player does the above and resumes
    // the game the player will be moving in the direction
    // that the key represents.

    /**
     * If the game is paused sends the key event to super
     * If the game is not paused sends the event to pauseMenuUpdater
     *
     * @param event
     */
    @Override
    public void keyReleased(KeyEvent event) {
        if (!paused) {
            super.keyReleased(event);
        } else {
            pauseMenuUpdater.keyReleased(event);
        }
    }


}
