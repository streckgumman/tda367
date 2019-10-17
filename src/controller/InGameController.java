package controller;

import model.Game;
import model.IntersectionDetector;
import model.Level;
import view.View;

import java.awt.event.KeyEvent;

/**
 * @author Amanda Dehlén
 * @author Linnea Johansson
 *
 * The in game controller that updates the model while playing.
 */
public class InGameController extends Controller {

    /**
     * Class constructor taking a view and a game as parameters.
     * Adds the player to the list of updaters.
     */
    @SuppressWarnings("unchecked")
    public InGameController(View view, Game game, GameExiter gameExiter, GameStateChanger nextLevelChanger) {
        super(view, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
        addUpdater(new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gameExiter.exit();
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
    }

    /**
     * A method that updates the model through the game's player.
     */
    protected void updateModel() {
        game.getPlayer().update();
    }


}
