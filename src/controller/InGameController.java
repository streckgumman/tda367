package controller;

import model.Game;
import model.IntersectionDetector;
import model.Level;
import view.View;

import java.awt.event.KeyEvent;

/**
 * The in game controller that updates the model while playing.
 *
 * @author Amanda Dehlén, Linnea Johansson
 */
public class InGameController extends Controller {

    /**
     * Class constructor taking a view and a game as parameters.
     * Adds the player to the list of updaters.
     */
    @SuppressWarnings("unchecked")
    public InGameController(View view, Game game, final MainController mainController) {
        super(view, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
        addUpdater(new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    mainController.exitGame();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {

            }
        });
    }

    /**
     * A method that updates the model through the game's player.
     */
    protected void updateModel() {
        game.getPlayer().update();
        if (IntersectionDetector.intersects(game.getPlayer().getHitbox(), game.getLevel().getItems().get(0).getHitbox())){
            System.out.println("IT WORKS");
        }
    }


}
