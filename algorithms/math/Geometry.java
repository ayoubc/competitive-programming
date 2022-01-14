
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
            return x * o.y - y * o.x;
        }

        public double dotProduct(Vector o){
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

    static int ccw(Point b, Point a, Point c){
        // counter clock wise
        // angle BAC;
        Vector v1 = new Vector(a, b);
        Vector v2 = new Vector(a, c);
        double x = v1.crossProduct(v2);
        return (x>0 ? 1 : (x<0 ? -1 : 0));
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
        int n = points.length;
        for (int i=0;i<n;i++)
            if (pointOnSegment(p, points[i], points[(i+1)%n])) return true;
        return false;
    }

    static int pointInPolygon(Point p, Point[] points) {
        double sum = 0;
        int n = points.length;

        for(int i=0;i<n;i++){
            int sign = ccw(points[i], p, points[(i+1)%n]);
            double A = angle(points[i], p, points[(i+1)%n]);
            sum += A*sign;
        }
        // 0 is in, 2 is out
        return (java.lang.Math.abs(java.lang.Math.abs(sum) - 2 * java.lang.Math.PI) < EPS  ? 0 : 2);
    }
}
