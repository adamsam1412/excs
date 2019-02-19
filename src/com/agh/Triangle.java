package com.agh;

public class Triangle {

    private static final int POINTS = 3;
    private final Point[] points = new Point[POINTS];

    public Triangle(Point a, Point b, Point c) {
        points[0] = a;
        points[1] = b;
        points[2] = c;

    }

    static class Point {
        private final double x;
        private final double y;
        public Point(double x, double y) {
            super();
            this.x = x;
            this.y = y;
        }

        public double euclidean(Point a){
            return Math.sqrt(Math.pow(x - a.x, 2) + Math.pow(y - a.y, 2));
        }
    }

    public double getArea(){
        double ab = points[0].euclidean(points[1]);
        double ac = points[0].euclidean(points[2]);
        double bc = points[1].euclidean(points[3]);
        double s = (ab + ac + bc) / 2;

        return Math.sqrt(s * (s - ab) * (s - ac) * (s - bc));
    }




}
