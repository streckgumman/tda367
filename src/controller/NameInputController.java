package controller;

import model.Game;
import view.View;

import java.awt.event.KeyEvent;

public class NameInputController extends Controller {

    private View view;
    private Game game;

    @SuppressWarnings("unchecked")
    public NameInputController(View v, MainController mainController) {
        super(v, null);
        this.view = v;
        this.game = mainController.getGame();

        Updater u = new Updater(null) {
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
                //playerName += event.getKeyChar();
            }
        };

        addUpdater(u);
    }



    @Override
    protected void redrawView() {
        super.redrawView();
        //view.drawText()
    }

    @Override
    protected void updateModel() {

    }
}
