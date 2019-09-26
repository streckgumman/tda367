import controller.Controller;
import controller.InGameController;
import controller.StartMenuController;
import model.Game;
import view.InGameView;
import view.StartMenuView;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args) {

//        Game game = new Game();
//        View screen = new View();
//        screen.testScreen();
//
//
//        KeyInput keyInput = new KeyInput();
//        screen.getWindow().addKeyListener(keyInput);

        int w = 1920;
        int h = 1080;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //final View view;
        //frame.add(view = new StartMenuView());


        final Game game = new Game();
        final View inGameView;
        frame.add(inGameView = new InGameView(game));


        frame.setSize(w, h - 100);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);



        //Controller c = new StartMenuController(view);
        Controller c2 = new InGameController(inGameView, game);                               //TODO Fel View
        //view.addKeyListener(c);
        inGameView.addKeyListener(c2);
    }

}
