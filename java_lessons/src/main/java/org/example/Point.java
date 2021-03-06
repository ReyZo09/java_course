package org.example;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static double range(Point a, Point b) {
        return Math.sqrt(Math.pow((b.x - a.x),2)+Math.pow((b.y - a.y),2));
    }
}
