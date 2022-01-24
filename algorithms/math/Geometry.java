package com.github;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Geometry {

    /**
     * can represent a point and also a vector
     * so for example for cross product, it will represent a vector
     */
    static double EPS = 1e-6;

    public class Point {
        public double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point o) {
            return x == o.x && y == o.y;
        }

        public void setCoords(Point p) {
            this.x = p.x;
            this.y = p.y;
        }

    }

    static class Vector {
        // represent the vector AB
        private Point a, b;
        public double x, y;

        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Vector(Point a, Point b) {
            this.a = a;
            this.b = b;
            this.x = b.x - a.x;
            this.y = b.y - a.y;
        }

        public double crossProduct(Vector o) {
            // cross means x
            // the area between those vectors
            // a x b = ||a|| x ||b|| x sin(teta) u, u is a vector perpondiculare to plane that contains a and b
            // teta is between a and b (the sign is important here, from a to b)
            // so ||axb|| = ||a|| x ||b|| x sin(teta)
            // a x b is the vector which is orthogonal to both a and b and which length is equal to the area of the
            // parallelogram formed by a and b
            return x * o.y - y * o.x;
        }

        public double dotProduct(Vector o){
            // dot means point
            // a.b = Sigma(a_i x b_i for i in [1,n]) where a = (a1, a2, ..., an), b = (b1, b2, ..., bn)
            // a.b = ||a|| x ||b|| x cos(teta) where teta is the angle between a and b
            // a.a = ||a|| x ||a|| ==> ||a|| = sqrt(a.a)
            return x * o.x + y * o.y;
        }

        public double magnitude() {
            return java.lang.Math.sqrt(x * x + y * y);
        }

        public boolean equals(Vector o) {
            return x == o.x && y == o.y;
        }
    }
    static boolean segmentsParallel(Point a, Point b, Point c, Point d){
        // if AB || CD
        Vector v1 = new Vector(a, b);
        Vector v2 = new Vector(c, d);
        return v1.crossProduct(v2) == 0; // sin(x) = 0
    }

    static double angle(Point a, Point p, Point b) {
        // compute the angle apb
        Vector v1 = new Vector(p, a);
        Vector v2 = new Vector(p, b);
        double x = v1.dotProduct(v2) / (v1.magnitude() * v2.magnitude());
        return java.lang.Math.acos((x>1 ? 1 : (x<-1 ? -1 : x)));
    }

//    static int ccw(Point b, Point a, Point c){
//        // angle BAC;
//        Vector v1 = new Vector(a, b); // vector AB
//        Vector v2 = new Vector(a, c); // Vector AC
//        double x = v1.crossProduct(v2);
//        // x == 1 => counter clockwise
//        // x == -1 => clockwise
//        // x == 0 => collinear
//        return (x>0 ? 1 : (x<0 ? -1 : 0));
//    }

    static int orientation(Point a, Point b, Point c) {
        Vector v1 = new Vector(a, b);
        Vector v2 = new Vector(b, c);
        double x = v1.crossProduct(v2);
        if (x > 0) return 1; // counter-clockwise, vector BC turns left relatively to AB
        if (x < 0) return -1; // clockwise
        return 0; // collinear
    }

    static boolean cw(Point a, Point b, Point c) {
        return  orientation(a, b, c) < 0;
    }

    static boolean ccw(Point a, Point b, Point c) {
        return orientation(a, b, c) > 0;
    }

    static boolean pointOnSegment(Point p, Point a, Point b){
        // p belongs to [a,b] or not
        if (p.equals(a)) return true;
        if (p.equals(b)) return true;

        Vector v1 = new Vector(p, a);
        Vector v2 = new Vector(p, b);

        return v1.crossProduct(v2) == 0 && v1.dotProduct(v2) < 0;
    }

    static boolean pointOnPolygon(Point p, Point[] points){
        // check if point p is on one of edges of polygon
        int n = points.length;
        for (int i=0;i<n;i++)
            if (pointOnSegment(p, points[i], points[(i+1)%n])) return true;
        return false;
    }

    static int pointInPolygon(Point p, Point[] points) {
        double sum = 0;
        int n = points.length;

        for(int i=0;i<n;i++){
            int sign = orientation(points[i], p, points[(i+1)%n]);
            double A = angle(points[i], p, points[(i+1)%n]);
            sum += A*sign;
        }
        // 0 is in, 2 is out
        return (java.lang.Math.abs(java.lang.Math.abs(sum) - 2 * java.lang.Math.PI) < EPS  ? 0 : 2);
    }

    static double polygonArea(Point[] coords) {
        // if the area is >= 0 the coords are given in CCW, otherwise it's CW
        double sum = 0;
        int n = coords.length;
        for (int i=0;i<n;i++) {
            int j = (i + 1) % n;
            sum += (coords[i].x)*(coords[j].y) - (coords[j].x)*(coords[i].y);
        }
        return java.lang.Math.abs(sum) / 2;
    }

    static List<Point> buildConvexHull(List<Point> points, final Point p0) {
        // Graham's scan Algorithm
        // p0 the bottom-most point
        // p0 can be found outside using the code bellow
//        final Point p0 = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
//        for (Point p: points) {
//            if (p0.y > p.y || (p0.y == p.y && p0.x > p.x)) {
//                p0.setCoords(p);
//            }
//        }

        Collections.sort(points, (p1, p2) -> {
            Vector v1 = new Vector(p0, p1);
            Vector v2 = new Vector(p1, p2);

            double o = v1.crossProduct(v2);
            if (o == 0) {
                Vector v3 = new Vector(p0, p2);
                if (v1.magnitude() < v3.magnitude()) return -1;
                return 1;
            }
            if (o > 0) return 1;
            return -1;
        });

        java.util.Vector<Point> st = new java.util.Vector();
        for (int i=0;i< points.size();i ++) {
            Point tmp = points.get(i);
            while (st.size() > 1 && !cw(st.get(st.size()-2), st.get(st.size()-1), tmp)) {
                st.removeElementAt(st.size()-1);
            }
            st.add(tmp);
        }

        // points in ccw
        List<Point>  ans = new ArrayList<>();
        ans.add(st.get(0));
        for (int i=st.size()-1;i>=1; i--) ans.add(st.get(i));
        return ans;
    }
}
