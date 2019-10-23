package controller;

import model.Game;
import view.View;

import java.awt.event.KeyEvent;

/**
 * Public class that handles the name input
 */
public class NameInputController extends Controller {

    private Game game;

    @SuppressWarnings("unchecked")
    /**
     * Constructor
     *
     * @param v the view
     * @param game the View
     * @param stateChanger the GameStateChanger
     * @param gameExiter the GameExiter
     */
    public NameInputController(View v, Game game, GameStateChanger stateChanger, GameExiter gameExiter) {
        super(v, game);
        v.setFocusTraversalKeysEnabled(false); //Don't let Tab bork the entire thing.
        this.game = game;

        Updater u = new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gameExiter.exit();
                } else if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    stateChanger.changeGameState();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {
                updatePlayerName(event.getKeyChar());
            }
        };


        addUpdater(u);
    }

    /**
     * Adds a character to the player's name, unless that character is '\b' (backspace), in which case it removes one character from the name.
     *
     * @param c The character to add to the Player's name
     */
    private void updatePlayerName(char c) {
        String playerName = game.getPlayer().getName();
        if (c == '\b') { //If the character that was input is backspace:
            game.getPlayer().setName(playerName.substring(0, Math.max(playerName.length() - 1, 0))); //Delete the last character in player name
        } else if ((int) c != 127) { //If the character that was input is also not delete:
            playerName += c;
            game.getPlayer().setName(playerName);
        }
    }

    /**
     * Calls the method redrawView from
     * NameInputController's super class
     */
    @Override
    protected void redrawView() {
        super.redrawView();
    }

    @Override
    protected void updateModel() {

    }
}
