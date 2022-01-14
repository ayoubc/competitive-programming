
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
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
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int l = in.nextInt();
            graph = new List[n+1];
            for (int i=0;i<=n;i++) graph[i] = new ArrayList<>();
            vis = new boolean[n+1];
            for (int i=0;i<m;i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                graph[a].add(b);
            }

            List<Integer> hand = new ArrayList<>();
            for (int i=0;i<l;i++) hand.add(in.nextInt());

            int ans = 0;
            for (Integer u : hand) {
                if (!vis[u]) {
                    cnt = 0;
                    dfs(u);
                    ans += cnt;
                }
            }
            out.println(ans);
        }


        out.close();
    }

    static void dfs(int start) {
        vis[start] = true;
        cnt ++;
        for(Integer u : graph[start]){
            if (!vis[u]) {
                dfs(u);
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
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}