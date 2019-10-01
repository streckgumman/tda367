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
    public InGameController(View view, Game game) {
        super(view, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
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
