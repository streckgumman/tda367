package controller;

import model.Level;
import view.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public abstract class Controller implements KeyListener{

    View view;
    Level level;
    List<Updater> updaters;


    public Controller(View view, Level level){
        this.level = level;
        this.view = view;

    }

    public void redrawView(){

    }

    public void keyPressed(KeyEvent e){
        for(Updater updater : updaters){
            updater.update(e);
        }
    }

    public void keyReleased(KeyEvent e){
        for(Updater updater : updaters){
            updater.update(e);
        }
    }

    public void keyTyped(KeyEvent e){
        for(Updater updater : updaters){
            updater.update(e);
        }
    }

}
