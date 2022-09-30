import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static int[] levels;
    static boolean[] vis;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();

        for (int tt=1;tt<=t;tt++) {
            int n = in.nextInt();
            int q = in.nextInt();
            graph = new List[n+1];
            levels = new int[n+1];
            vis = new boolean[n+1];

            levels[1] = 1;
            for (int i=1;i<n;i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                addEdge(a, b);
            }

            dfs(1, -1);
            int[] totNodeInLevel = new int[n+1];
            int[] waterLevel = new int[n+1];

            for (int i=1;i<=n;i++) {
                totNodeInLevel[levels[i]] ++;
            }

            for (int qq=0;qq<q;qq++) {
                int i = in.nextInt();
                int l = 1;
                while (l <= n && waterLevel[l] == totNodeInLevel[l]) l++;

                waterLevel[l] ++;
            }

            int ans = 0;
            int l = 1;
            while (l <= n && waterLevel[l] == totNodeInLevel[l]) {
                ans += totNodeInLevel[l];
                l ++;
            }
            out.println("Case #" + tt + ": " + ans);
        }
        out.close();
    }
    static void addEdge(int a, int b) {
        if (graph[a] == null) graph[a] = new ArrayList<>();
        if (graph[b] == null) graph[b] = new ArrayList<>();
        graph[a].add(b);
        graph[b].add(a);
    }
    static void dfs(int s, int p) {
        if (p != -1) levels[s] = levels[p] + 1;
        vis[s] = true;
        if (graph[s] != null) {
            for (Integer x : graph[s]) {
                if (!vis[x]) dfs(x, s);
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
