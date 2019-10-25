package controller;

/**
 * @author Johannes Kvernes
 * <p>
 * Interface with method for changeing the game state
 */
@FunctionalInterface
public interface GameStateChanger {

    /**
     * Method to change the game state
     * To be implemented by classes
     * which use the interface
     */
    void changeGameState();
}
