package test;

import model.Hitbox;
import model.IntersectionDetector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Amanda Dehlén
 *
 * Tests the method in the class IntersectionDetector
 */
public class TestIntersectionDetector {

    /**
     * Tests the method intersects
     *
     * Checks so the method returns true when the hitboxes have the exact same position
     * and width and height
     *
     * Checks so the method returns true when the hitboxes do not have the exact same
     * position but the hitboxes overlaps
     *
     * Checks so the method returns false when the hitboxes do not overlaps
     *
     * Checks so the method returns false when the hitboxes are located right next to
     * each other so the left bottom corner of the first hitbox are in the same place as
     * the right top corner of the second hitbox
     */
    @Test
    public void testIntersects(){
        Hitbox hitbox1 = new Hitbox(10, 10, 20, 20);
        Hitbox hitbox2 = new Hitbox(10,10,20,20);
        assertTrue(IntersectionDetector.intersects(hitbox1,hitbox2));

        hitbox2 = new Hitbox(20,20, 10,10);
        assertTrue(IntersectionDetector.intersects(hitbox1,hitbox2));

        hitbox1.setX(0);
        hitbox1.setY(0);
        assertFalse(IntersectionDetector.intersects(hitbox1,hitbox2));

        hitbox1 = new Hitbox(10,10,10,10);
        hitbox2 = new Hitbox(20,20,10,10);
        assertFalse(IntersectionDetector.intersects(hitbox1,hitbox2));
    }




}
