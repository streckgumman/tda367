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
     * @param view             the View that InGameController holds
     * @param game             the Game that InGameController holds
     * @param gameExiter       the GameExiter that InGameController holds
     * @param nextLevelChanger the GameStateChanger that InGameController holds
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
        game.addObserver(view); //When you create a new InGameController, add the view as an observer to all GameObjects
    }

    /**
     * Updates the model every frame.
     */
    protected void updateModel() {
        if (!paused) {
            game.getPlayer().update();
        }
        game.updateModel();
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
