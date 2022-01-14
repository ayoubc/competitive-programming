import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static double EPS = 1e-6;

    static List<Integer>[] graph;
    static boolean[] vis;
    static char[][] grid;
    static int cnt;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        String[] ans = new String[] {"in","on","out"};

        while (true) {
            int n = in.nextInt();
            if (n == 0) break;
            Point[] points = new Point[n];
            for (int i=0;i<n;i++) points[i] = new Point(in.nextInt(), in.nextInt());

            int m = in.nextInt();
            for (int i=0;i<m;i++) {
                Point p = new Point(in.nextInt(), in.nextInt());
                if (pointOnPolygon(p, points)) out.println("on");
                else out.println(ans[pointInPolygon(p, points)]);
            }
        }

        out.close();
    }

    static double angle(Point a, Point p, Point b) {
        // compute the angle apb
        Vector v1 = new Vector(p, a);
        Vector v2 = new Vector(p, b);
        double x = v1.dotProduct(v2) / (v1.magnitude() * v2.magnitude());
        return Math.acos((x>1 ? 1 : (x<-1 ? -1 : x)));
    }
    static int ccw(Point b, Point a, Point c){
        //angle BAC;
        Vector v1 = new Vector(a, b);
        Vector v2 = new Vector(a, c);
        int x = v1.crossProduct(v2);
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

        return (Math.abs(Math.abs(sum) - 2 * Math.PI) < EPS  ? 0 : 2);
    }

    static class Vector {
        // represent the vector AB
        private Point a, b;
        public int x, y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Vector(Point a, Point b) {
            this.a = a;
            this.b = b;
            this.x = b.x - a.x;
            this.y = b.y - a.y;
        }

        public int crossProduct(Vector o) {
            return x * o.y - y * o.x;
        }

        public int dotProduct(Vector o){
            return x * o.x + y * o.y;
        }

        public double magnitude() {
            return Math.sqrt(x * x + y * y);
        }

        public boolean equals(Vector o) {
            return x == o.x && y == o.y;
        }
    }

    static class Point{
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point o) {
            return x == o.x && y == o.y;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}