package controller;

/**
 * @author Johannes Kvernes
 * <p>
 * Interface with method for exiting the game
 */
@FunctionalInterface
public interface GameExiter {

    /**
     * Method to exit the game
     * To be implemented by classes
     * which use the interface
     */
    void exit();
}
