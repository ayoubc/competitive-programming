
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;

    static char[][] grid;
    static int[] ids;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();

        for (int i=0;i<n;i++) {
            int m = in.nextInt();

            ids = new int[m];

            List<Point> points = new ArrayList<>();
            for (int j=0;j<m;j++) {
                double x = in.nextDouble();
                double y = in.nextDouble();
                points.add(new Point(x, y));
                ids[j] = j;
            }

            List<Edge> edges = new ArrayList<>();
            for (int j=0;j<m;j++) {
                for (int k=j+1;k<m;k++) {
                    edges.add(new Edge(j, k, dist(points.get(j), points.get(k))));
                }
            }

            Collections.sort(edges);
            out.println(kruskal(edges));
        }

        out.close();
    }

    static int root(int i) {
        while (ids[i] != i){

            // path compression
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    static void union(int i, int j) {
        ids[root(i)] = ids[root(j)];
    }

    static double kruskal(List<Edge> edges) {
        double minCost = 0.0;
        for (int i=0;i<edges.size(); i++) {
            Edge edge = edges.get(i);
            if (root(edge.u) != root(edge.v)) {
                minCost += edge.w;
                union(edge.u, edge.v);
            }
        }
        return minCost;
    }

    static double square(double x) {
        return x * x;
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt(square(p1.x - p2.x) + square(p1.y - p2.y));
    }

    static class Edge implements Comparable{
        public int u;
        public int v;
        public double w;

        static double EPS = 10e-6;

        public Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Object o) {
            Edge e = (Edge)o;
            if (Math.abs(w - e.w) <= EPS) return 0;
            else if (w < e.w) return -1;
            return 1;
        }
    }

    static class Point {
        public double x;
        public double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
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