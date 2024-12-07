import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;
    static int ans = 0;
    static boolean isPart2;
    static int maxLen;
    //    static double[] xLimit = {7, 27};
//    static double[] yLimit = {7, 27};
    static double[] xLimit = {200000000000000d, 400000000000000d};
    static double[] yLimit = {200000000000000d, 400000000000000d};

    public static void main(String[] args) {
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);
        out.println(part1(lines));
        out.close();
    }
    static List<Point> readPoints(List<String> lines) {
        List<Point> res = new ArrayList<>();
        for (String line: lines) res.add(new Point(line.split("\\s+@\\s+")));
        return res;
    }
    static class V {
        double x, y, z;
        public V(String s) {
            String[] tmp = s.split(",\\s+");
            x = Double.parseDouble(tmp[0]);
            y = Double.parseDouble(tmp[1]);
            z = Double.parseDouble(tmp[2]);
        }
    }
    static class Point {
        double x, y, z;
        V v;
        double a;
        double b;
        double c;
        public Point(String coords, String v) {
            String[] tmp = coords.split(",\\s+");
            x = Double.parseDouble(tmp[0]);
            y = Double.parseDouble(tmp[1]);
            z = Double.parseDouble(tmp[2]);
            this.v = new V(v);
            setParams();
        }
        public void setParams() {
            a = v.y;
            b = -1 * v.x;
            c = v.y * x - v.x * y;
        }
        public Point(double x, double y, double z, V v) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.v = v;
        }
        public Point(String[] args) {
            this(args[0], args[1]);
        }
        public boolean isIntersect(Point p) {
//            double det = A1 * B2 - A2 * B1
//            if (det == 0) {
//                //Lines are parallel
//            } else {
//                double x = (B2 * C1 - B1 * C2) / det
//                double y = (A1 * C2 - A2 * C1) / det
//            }
            double det = this.a * p.b - p.a * this.b;
            if (det == 0) return false;
            double nx = (p.b * this.c - this.b * p.c) / det;
            double ny = (this.a * p.c - p.a * this.c) / det;
            double t1 = (nx - x) / v.x;
            double t2 = (nx - p.x) / p.v.x;
            if (t1 < 0 || t2 < 0) return false;
            return isValid(nx, ny);
        }
        public boolean isValid(double x, double y) {
            boolean ok = (x >= xLimit[0] && x <= xLimit[1]) && (y >= yLimit[0] && y <= yLimit[1]);
            if(ok) {
                out.println("x="+x+",  y="+y);
            }
            return ok;
        }
    }

    static long part1(List<String> lines) {
        List<Point> points = readPoints(lines);
        int ans = 0;
        for (int i=0;i<points.size();i++) {
            for(int j=i+1;j<points.size();j++) {
                Point a = points.get(i);
                Point b = points.get(j);
                if (a.isIntersect(b)) ans++;
            }
        }
        return ans;
    }

    static long part2(List<String> lines) {
        return 0;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }
    }
}