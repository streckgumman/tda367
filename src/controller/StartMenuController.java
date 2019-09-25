package controller;

import view.View;

import java.awt.event.KeyEvent;

public class StartMenuController extends Controller{

    public StartMenuController(View v){
        super(v, null);
        Updater u = new Updater(null) {
            @Override
            public void update(KeyEvent event) {
                if(event.getKeyCode() == java.awt.event.KeyEvent.VK_E){
                    System.out.println("E-key pressed");//Nästa steg så ska vi starta InGameView
                } else if (event.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
                    redrawView();
                }
            }
        };

        addUpdater(u);
    }

}
