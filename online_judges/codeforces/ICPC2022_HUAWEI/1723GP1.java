import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<P>[] graph;
    static HashSet<Integer> vis;
    static int N = 2;
    static int n;
    static char[][] grid;
    static List<HashSet<Integer>> partitions;
    static int totalWCut;
    public static void main(String[] args){

        InputStream is;

        try {
            is = new FileInputStream(".\\src\\input\\01");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        int m = in.nextInt();

        graph = new List[n];
        vis = new HashSet<>();
        Edge[] edges = new Edge[m];
        partitions = new ArrayList<>();
        for (int i=0;i<m;i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            edges[i] = new Edge(u, v, w);
            addEdge(u, v, w);
        }
        Arrays.sort(edges, (e1, e2) -> {
            int c =  Integer.compare(e1.w, e2.w) * -1;
            if (c == 0) c = Double.compare(e1.getW(), e2.getW());
            return c;
        });

        // cut the first N edges with big weights
        N = Math.max(m - (m / 3), 1);
        for (int i=0;i<N;i++) {
            cutEdge(edges[i].u, edges[i].v);
            totalWCut += edges[i].w;
        }

        for (int i=0;i<n;i++) {
            if (!vis.contains(i)) {
                HashSet<Integer> s = new HashSet<>();
                dfs(i, s);
                partitions.add(s);
            }
        }

//      checkIfSeparate(out);

        printPartitions(out);
        out.close();
    }
    static void printPartitions(PrintWriter out) {
        out.println(partitions.size());
        for (HashSet<Integer> hs: partitions) {
            out.print(hs.size() + " ");
            for (Integer d: hs) out.print(d + " ");
            out.println();
        }
    }
    static void checkIfSeparate(PrintWriter out) {
        boolean flag = true;
        for (int i=0;i<partitions.size();i++) {
            for (int j=0;j<partitions.size();j++) {
                if (i == j) continue;
                if (!ok(partitions.get(i), partitions.get(j))) {
                    out.println("WA");
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
    }
    static boolean breakEdge1() {
        int x = (int)Math.floor(Math.random()*(2));
        // break this edge
        if (x == 0) return true;
        return false;
    }
    static boolean breakEdge2(int i) {
        return i % 3 == 0;
    }
    static boolean ok(HashSet<Integer> p1, HashSet<Integer> p2) {
        for (Integer d : p1){
            if (p2.contains(d)) return false;
        }
        return true;
    }
    public static void addEdge(int a, int b, int w) {
        if (graph[a] == null) graph[a] = new ArrayList<>();
        if (graph[b] == null) graph[b] = new ArrayList<>();
        graph[a].add(new P(b, w));
        graph[b].add(new P(a, w));
    }
    static void cutEdge(int u, int v) {
        for (P p : graph[u]) {
            if (p.u == v) p.cut();
        }
        for (P p : graph[v]) {
            if (p.u == u) p.cut();
        }
    }
    static class P {
        int u, w;
        boolean cutted;
        public P(int u, int w) {
            this.u = u;
            this.w = w;
            cutted = false;
        }
        public void cut() {
            cutted = true;
        }
    }
    static class Edge {
        int u, v , w;
        public Edge(int a, int b, int c) {
            u = a;
            v = b;
            w = c;
        }
        public int getW1() {
            return w * 6 + graph[u].size() * 2 + graph[v].size() * 2;
        }
        public int getW2() {
            return graph[u].size() + graph[v].size();
        }
        public double getW() {
            return (w * 1.0) / (graph[u].size() + graph[v].size());
        }
    }
    static int rtSize() {
        int x = 0;
        for (HashSet<Integer> s : partitions) x = Math.max(x, s.size());
        return x;
    }
    static double score() {
        double d =  N - rtSize() + (totalWCut * 1.0)/ 1000000000;
        return d;
    }
    static void dfs(int s, HashSet<Integer> currSet) {
        vis.add(s);
        currSet.add(s);
        if (graph[s] == null) return;
        for (P p : graph[s]) {
            if (!vis.contains(p.u) && !p.cutted) {
                dfs(p.u, currSet);
            }
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
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}