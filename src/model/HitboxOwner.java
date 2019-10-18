package model;

/**
 * @author Anna Nilsson
 * <p>
 * Interface with method for getting a hitbox
 */
public interface HitboxOwner {

    /**
     * Method to get hitboxes
     * To be implemented by classes
     * which use the interface
     */
    Hitbox getHitbox();
}
