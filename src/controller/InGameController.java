package controller;

import model.Game;
import model.Level;
import view.View;

import java.awt.event.KeyEvent;

public class InGameController extends Controller{

    public InGameController(View view, Game game) {
        super(view, null, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
    }



}
