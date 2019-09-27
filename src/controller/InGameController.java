package controller;

import model.Game;
import model.Level;
import view.View;

import java.awt.event.KeyEvent;

/**
 * The in game controller that updates the model while playing
 *
 * @author Amanda Dehlén, Linnea Johansson
 *
 */
public class InGameController extends Controller{

    public InGameController(View view, Game game) {
        super(view, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
    }

    protected void updateModel() {
        game.getPlayer().update();
    }


}
