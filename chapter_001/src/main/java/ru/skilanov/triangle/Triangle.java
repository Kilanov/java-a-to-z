package ru.skilanov.triangle;

/**
 * This class find triangle area if it's possible.
 */
public class Triangle {
    /**
     * @param first side abDistance double.
     * @param second side bcDistance double.
     * @param third side caDistance double.
     */
    double abDistance;
    double bcDistance;
    double caDistance;

    public Triangle(Point a, Point b, Point c) {
        abDistance = a.distanceTo(b);
        bcDistance = b.distanceTo(c);
        caDistance = c.distanceTo(a);
    }

    /**
     * Checked is it possible to create triangle.
     */
    public boolean exists() throws Exception {
        if ((abDistance + bcDistance > caDistance) &&
                (abDistance + caDistance > bcDistance) &&
                (bcDistance + caDistance > abDistance)) {
            return true;
        } else {
            throw new Exception("Triangle doesn't exist");
        }
    }

    /**
     * Find area.
     */
    public double area() {
        return (abDistance + bcDistance + caDistance) / 2;
    }
}