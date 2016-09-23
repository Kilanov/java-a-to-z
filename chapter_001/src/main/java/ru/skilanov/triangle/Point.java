package ru.skilanov.triangle;

/**
 * This class calculate distance between two points.
 */
public class Point {
    /**
     * @param first point x  double.
     * @param second point y double.
     */

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Mathematical expressions of distance between two points
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2));
    }
}