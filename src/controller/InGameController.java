package controller;

import model.*;
import view.View;

import java.awt.event.KeyEvent;

/**
 * The in game controller that updates the model while playing.
 *
 * @author Amanda Dehlén, Linnea Johansson
 */
public class InGameController extends Controller {

    /**
     * Class constructor taking a view and a game as parameters.
     * Adds the player to the list of updaters.
     */
    @SuppressWarnings("unchecked")
    public InGameController(View view, Game game, final MainController mainController) {
        super(view, game);
        addUpdater(new PlayerUpdater(game.getPlayer()));
        addUpdater(new Updater(null) {
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

            }
        });
        addUpdater(new ItemInteractionUpdater(game.getPlayer(), game));
        addUpdater(new NPCInteractionUpdater(game.getPlayer(), game));
        addUpdater(new PuzzleInteractionUpdater(game.getPlayer(), game, mainController));
        game.addObserver(view); //When you create a new InGameController, add the view as an observer to all GameObjects
    }

    /**
     * Updates the model every frame. @TODO This logic should reasonably not be done by a controller.
     */
    protected void updateModel() {
        for (NPC npc : game.getLevel().getNpcs()) {
            if (!IntersectionDetector.intersects(npc.getHitbox(), game.getPlayer().getHitbox())) {
                npc.stopTalking();
            }
        }

        for (GameObject g : game.getLevel().getGameObjects()) {
            g.update();
        }
    }


}
