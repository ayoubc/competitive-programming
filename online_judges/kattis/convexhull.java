
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static char[][] grid;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            try {
                int n = in.nextInt();
                if (n == 0) break;

                List<Point> points = new ArrayList<>();
                Point p0 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
                HashSet<Point> mp = new HashSet<>();
                for (int i=0;i<n;i++) {
                    Point p = new Point(in.nextInt(), in.nextInt());
                    if (p0.y > p.y || (p0.y == p.y && p0.x > p.x)) {
                        p0.setCoords(p);
                    }
                    if (!mp.contains(p)) {
                        points.add(p);
                        mp.add(p);
                    }

                }

                List<Point> ch = buildConvexHull(points, p0);

                out.println(ch.size());
                for (Point p: ch) {
                    out.println(p.x + " " + p.y);
                }

            } catch (NullPointerException e) {break;}
        }

        out.close();
    }

    static List<Point> buildConvexHull(List<Point> points, final Point p0) {
        // Graham's scan Algorithm
        // p0 the bottom-most point
        // p0 can be found with the code bellow
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

    static int orientation(Point a, Point b, Point c) {
        Vector v1 = new Vector(a, b);
        Vector v2 = new Vector(b, c);
        double x = v1.crossProduct(v2);
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    static boolean cw(Point a, Point b, Point c) {
        return  orientation(a, b, c) < 0;
    }

    static class Point {
        public int x, y;
        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void setCoords(Point p) {
            this.x = p.x;
            this.y = p.y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
            return Math.sqrt(x * x + y * y);
        }

        public boolean equals(Vector o) {
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
        public double nextDouble() {return Double.parseDouble(next());}
    }
}