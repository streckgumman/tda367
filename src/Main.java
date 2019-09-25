import controller.KeyInput;
import model.Game;
import view.View;


public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        View screen = new View();
        screen.testScreen();



        KeyInput keyInput = new KeyInput();
        screen.getWindow().addKeyListener(keyInput);
    }

}
