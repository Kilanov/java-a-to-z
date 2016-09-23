package ru.skilanov.triangle;

/**
 * This class find triangle area if it's possible.
 */
public class Triangle {
    /**
     * @param first point a  double.
     * @param second point b double.
     * @param third point c double.
     * @param fourth side abDistance double.
     * @param fifth side bcDistance double.
     * @param sixth side caDistance double.
     */

    public Point a;
    public Point b;
    public Point c;
    double abDistance;
    double bcDistance;
    double caDistance;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
        double area = (abDistance + bcDistance + caDistance) / 2;
        return area;
    }
}