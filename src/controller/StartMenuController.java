package controller;

import view.View;

import java.awt.event.KeyEvent;

public class StartMenuController extends Controller {

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
