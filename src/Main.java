import controller.MainController;


public class Main {

    public static void main(String[] args) {
        MainController mainController = MainController.getInstance();
        mainController.startGame();
    }
}
