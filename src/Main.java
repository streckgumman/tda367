import controller.Controller;
import controller.StartMenuController;
import view.StartMenuView;
import view.View;

import javax.swing.*;


public class Main {

    private static Main instance;
    private Controller controller;


    public static void main(String[] args) {
        int w = 1920;
        int h = 1080;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final View view;
        frame.add(view = new StartMenuView());

        frame.setSize(w, h - 100);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);

        Controller c = new StartMenuController(view);
        view.addKeyListener(c);

        // calls the controller's update method 60 times per second (ideally)
        while (true) {
            long startTime = System.currentTimeMillis();
            c.update();
            long totalTime = System.currentTimeMillis() - startTime;
            if (totalTime < 16) {
                try {
                    Thread.sleep(16 - totalTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
