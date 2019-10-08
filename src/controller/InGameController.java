package controller;

import model.Game;
import model.IntersectionDetector;
import model.Level;
import view.InGameView;
import view.View;

import java.awt.event.KeyEvent;

/**
 * The in game controller that updates the model while playing.
 *
 * @author Amanda Dehlén, Linnea Johansson
 */
public class InGameController extends Controller {

    private boolean paused = false;
    PauseMenuUpdater pauseMenuUpdater;

    /**
     * Class constructor taking a view and a game as parameters.
     * Adds the player to the list of updaters.
     */
    @SuppressWarnings("unchecked")
    public InGameController(View view, Game game) {
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
        addUpdater(new ItemInteractionUpdater(game.getPlayer(), game.getLevel()));
        addUpdater(new NPCInteractionUpdater(game.getPlayer(), game.getLevel()));

        pauseMenuUpdater = new PauseMenuUpdater(this);
    }

    /**
     * A method that updates the model through the game's player.
     */
    protected void updateModel() {
        if (!paused) {
            game.getPlayer().update();
        }
    }

    public void pause() {
        paused = true;
        ((InGameView) getView()).setPaused(true);
        pauseMenuUpdater.alreadyClicked = true;
    }

    public void play() {
        paused = false;
        ((InGameView) getView()).setPaused(false);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (!paused) {
            super.keyPressed(event);
        } else {
            pauseMenuUpdater.keyPressed(event);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (!paused) {
            super.keyReleased(event);
        } else {
            pauseMenuUpdater.keyReleased(event);
        }
    }


}
