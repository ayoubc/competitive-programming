
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static int a,b,m,sigma;
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
            try{
                int n = in.nextInt();
                if (n == 0) break;

                Sphere[] ballons = new Sphere[n];
                for (int i=0;i<n;i++) ballons[i] = new Sphere(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());


                boolean[] vis = new boolean[n];

                int m = in.nextInt();
                int[] ans = new int[m];
                for (int i=0;i<m;i++) {
                    Vector v = new Vector(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
                    for (int j=0;j<n;j++) {
                        if (ballons[j].intersection(v) >= 0 && !vis[j]) {
                            vis[j] = true;
                            ans[i] ++;
                        }
                    }
                }
                for (int x: ans) out.println(x);

            } catch (NullPointerException e) {break;}
        }

        out.close();
    }

    static class Point {
        public double x, y, z;
        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean equals(Point o) {
            return x == o.x && y == o.y && z == o.z;
        }

        public double distance(Point o) {
            return Math.pow(o.x - x, 2) + Math.pow(o.y - y, 2) + Math.pow(o.z - z, 2);
        }
    }

    static class Vector {
        public Point p;
        public double x, y, z;

        public Vector(double xp, double yp, double zp, double x, double y, double z) {
            this.p = new Point(xp, yp, zp);
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Sphere {
        public double r, s, x, y, z;
        public Sphere(double r, double s, double x, double y) {
            this.r = r;
            this.s = s;
            this.x = x;
            this.y = y;
            this.z = s + r;
        }

        public double intersection(Vector v) {
            double a = Math.pow(v.x, 2) + Math.pow(v.y, 2) + Math.pow(v.z, 2);
            double b = 2 * (v.x * (v.p.x - x) + v.y * (v.p.y - y) + v.z * (v.p.z - z));
            double c = Math.pow(v.p.x - x, 2) + Math.pow(v.p.y - y, 2) + Math.pow(v.p.z - z, 2) - Math.pow(r, 2);

            double delta = Math.pow(b, 2) - 4 * a * c;
            if (delta <= 0) return -1;

            double u = (Math.sqrt(delta) - b) / (2 * a);
            if (u < 0) return -1;
            return Math.pow(u * v.x, 2) + Math.pow(u * v.y, 2) + Math.pow(u * v.p.z, 2);
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