package controller;

import model.Game;
import view.View;

import java.awt.event.KeyEvent;

public class NameInputController extends Controller {

    private Game game;

    @SuppressWarnings("unchecked")
    public NameInputController(View v, MainController mainController) {
        super(v, mainController.getGame());
        v.setFocusTraversalKeysEnabled(false); //Don't let Tab bork the entire thing.
        this.game = mainController.getGame();

        Updater u = new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    mainController.exitGame();
                } else if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    mainController.switchToIngame();
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

    @Override
    protected void redrawView() {
        super.redrawView();
    }

    @Override
    protected void updateModel() {

    }
}