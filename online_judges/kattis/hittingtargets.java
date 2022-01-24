
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
        int m = in.nextInt();
        Shape[] shapes = new Shape[m];
        for (int i=0;i<m;i++) {
            String type = in.next();
            if (type.equals("circle")) shapes[i] = new Circle(in.nextInt(), in.nextInt(), in.nextInt());
            else shapes[i] = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
        int n = in.nextInt();
        for (int i=0;i<n;i++) {
            Point p = new Point(in.nextInt(), in.nextInt());
            int ans = 0;
            for (int j=0;j<m;j++) ans += shapes[j].IsPointIn(p) ? 1 : 0;

            out.println(ans);
        }

        out.close();
    }

    static class Point {
        public double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point o) {
            return x == o.x && y == o.y;
        }

        public double distance(Point o) {
            return Math.pow(o.x - x, 2) + Math.pow(o.y - y, 2);
        }
    }

    static interface Shape {
        public boolean IsPointIn(Point p);
    }

    static class Rectangle implements Shape {
        public int x1, y1, x2, y2;
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        public boolean IsPointIn(Point p) {
            return p.x >= x1 && p.x <= x2 && p.y >= y1 && p.y <= y2;
        }
    }

    static class Circle implements Shape {
        public int r;
        Point center;
        public Circle (int x, int y, int r) {
            this.center = new Point(x, y);
            this.r = r;
        }
        public boolean IsPointIn(Point p) {
            return center.distance(p) <= r * r;
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