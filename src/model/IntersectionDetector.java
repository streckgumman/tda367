package model;

public class IntersectionDetector {

    /**
     * Checks if hitboxes overlap
     *
     * @return whether or not the hitboxes overlap
     */
    public static boolean intersects(Hitbox h1, Hitbox h2) {
        return h1.getX() + h1.getWidth() > h2.getX() && h1.getX() < h2.getX() + h2.getWidth() &&
                h1.getY() + h1.getHeight() > h2.getY() && h1.getY() < h2.getY() + h2.getHeight();

    }
}
