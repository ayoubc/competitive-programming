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
            ans = 0;
            permutations(N, initiators);
            out.println("Case #" + tt + ": " + ans);

        }
        out.close();
    }

    static int maxInChain(int s, boolean[] vis){
        int res = F[s];
        int cur = s;
        while (cur != 0) {
            if (!vis[cur]) res = Math.max(res, F[cur]);
            vis[cur] = true;
            cur = graph[cur].get(0);
        }
        return res;
    }
    static void permutations(int N, int[] elements) {
        if(N == 1) {
            boolean[] vis = new boolean[n+1];
            long result = 0;
            for (int i=0;i<elements.length;i++) {
                result += maxInChain(elements[i], vis);
            }
            ans = Math.max(result, ans);
        } else {
            for(int i = 0; i < N-1; i++) {
                permutations(N - 1, elements);
                if(N % 2 == 0) {
                    swap(elements, i, N - 1);
                } else {
                    swap(elements, 0, N - 1);
                }
            }
            permutations(N - 1, elements);
        }
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