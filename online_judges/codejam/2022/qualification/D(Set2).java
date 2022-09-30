import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static int MAX = 1000001;
    static long ans = 0;
    static int[] F;
    static int[] P;
    static List<Integer>[] leafs;
    static long[] dp;
    static int n;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int tt=1;tt<=t;tt++){
            n = in.nextInt();

            F = new int[n+1];
            P = new int[n+1];

            for (int i=1;i<=n;i++) F[i] = in.nextInt();
            for (int i=1;i<=n;i++) P[i] = in.nextInt();

            graph = new List[n+1];
            for (int i=1;i<=n;i++) {
                if (graph[i] == null) graph[i] = new ArrayList<>();
                graph[i].add(P[i]);
                if (graph[P[i]] == null) graph[P[i]] = new ArrayList<>();
                graph[P[i]].add(i);
            }

            int N = 0;
            for (int i=1;i<=n;i++) {
                if (graph[i].size() == 1) N++;
            }

            int[] initiators = new int[N];
            int j =0;
            for (int i=1;i<=n;i++) {
                if (graph[i].size() == 1) initiators[j++] = i;
            }

            leafs = new List[n+1];

            for (int k=0;k<N;k++) {
                int cur = initiators[k];
                while (cur != 0) {
                    if (cur != initiators[k]) {
                        if (leafs[cur] == null) leafs[cur] = new ArrayList<>();
                        leafs[cur].add(initiators[k]);
                    }
                    cur = P[cur];
                }
            }

            dp = new long[n+1];
            for (int i=1;i<=n;i++) dp[i] = -1;
            ans = 0;
            for(int i=1;i<=n;i++) {
                if (P[i] == 0) {
                    ans += Ftree(i);
                }
            }
            out.println("Case #" + tt + ": " + ans);

        }
        out.close();
    }

    static long Ftree(int s) {
        if (graph[s].size() == 1) return F[s];

        if (dp[s] != -1) return dp[s];
        long res = 0;
        for (Integer x: leafs[s]) {
            int maxPath = 0;
            int cur = x;
            int prev = -1;
            long tmpSum = 0;
            while (cur != P[s]) {
                maxPath = Math.max(maxPath, F[cur]);
                if (prev != -1) {
                    for (Integer child: graph[cur]) {
                        if (child != prev && child != P[cur]) {
                            tmpSum += Ftree(child);
                        }
                    }
                }
                prev = cur;
                cur = P[cur];
            }
            res = Math.max(res, tmpSum + maxPath);
        }
        dp[s] = res;
        return res;
    }
    static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
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