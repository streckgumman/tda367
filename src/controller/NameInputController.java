package controller;

import view.View;
import java.awt.event.KeyEvent;



public class NameInputController extends Controller {

    String playerName;

    @SuppressWarnings("unchecked")
    public NameInputController(View v, MainController mainController) {
        super(v, null);

        Updater u = new Updater(null) {
            @Override
            public void keyPressed(KeyEvent event) {

            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {
                playerName += event.getKeyChar();
            }
        };
    }

    @Override
    protected void updateModel() {

    }
}
