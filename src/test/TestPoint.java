package test;

import model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Amanda Dehlén
 * <p>
 * Tests the method of the class Point
 */
public class TestPoint {

    private Point point;

    /**
     * Tests the methods getX and getY
     */
    @Test
    public void testGetXandGetY() {
        point = new Point(35, 60);
        assertEquals(35, point.getX());
        assertEquals(60, point.getY());
    }

    /**
     * Tests the methods setX and setY
     */

    @Test
    public void testSetXandSetY() {
        point = new Point(35, 50);

        point.setX(20);
        point.setY(10);
        assertEquals(20, point.getX());
        assertEquals(10, point.getY());
    }
}
