/**
 * This class find triangle area if it's possible.
 */
public class Triangle {
    /**
     * @param first point a  double.
     * @param second point b double.
     * @param third point c double.
     */

    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * find side length, checked is it possible to create, find area.
     */

    public double area() {
        double abDistance = a.distanceTo(b);
        double bcDistance = b.distanceTo(c);
        double caDistance = c.distanceTo(a);

        if ((abDistance + bcDistance > caDistance) &&
                (abDistance + caDistance > bcDistance) &&
                (bcDistance + caDistance > abDistance)) {

            double area = (abDistance + bcDistance + caDistance) / 2;
            return area;
        }
        return -1;
    }
}