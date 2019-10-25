package controller;

import view.View;

import java.awt.event.KeyEvent;

/**
 * Public class that controls the start menu
 */
public class StartMenuController extends Controller {

    /**
     * Constructor for the class
     *
     * @param v            the view
     * @param stateChanger used to change the state of the game
     * @param gameExiter   used to exit the game
     */
    @SuppressWarnings("unchecked")
    public StartMenuController(View v, GameStateChanger stateChanger, GameExiter gameExiter) {
        super(v, null);

        Updater u = new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == java.awt.event.KeyEvent.VK_E) {
                    stateChanger.changeGameState();
                } else if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gameExiter.exit();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {

            }
        };

        addUpdater(u);
    }

    @Override
    public void updateModel() {

    }
}
