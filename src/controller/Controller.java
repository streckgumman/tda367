package controller;

import model.Game;
import model.Level;
import view.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller implements KeyListener{

    View view;
    Level level;
    List<Updater> updaters;
    Game game;


    public Controller(View view, Level level, Game game){
        this.level = level;
        this.view = view;
        this.game = game;
        updaters = new ArrayList<Updater>();

    }

    public void redrawView(){
        view.repaint();
    }

    public void keyPressed(KeyEvent e){
        System.out.println("you pressed a key");
        for(Updater updater : updaters){
            updater.keyPressed(e);
        }
    }

    public void keyReleased(KeyEvent e){
        for(Updater updater : updaters){
            updater.keyReleased(e);
        }
    }

    public void keyTyped(KeyEvent e){
        for(Updater updater : updaters){
            updater.keyTyped(e);
        }
    }

    public void addUpdater(Updater u) {
        updaters.add(u);
    }

}
