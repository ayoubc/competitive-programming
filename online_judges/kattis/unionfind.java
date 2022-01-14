
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

        int n = in.nextInt();
        int q = in.nextInt();

        UnionFind unionFind = new UnionFind(n);
        while (q-- > 0) {
            char c = in.next().charAt(0);
            int a = in.nextInt();
            int b = in.nextInt();
            if (c == '=') unionFind.union(a,b);
            else out.println(unionFind.isConnected(a, b) ? "yes" : "no");
        }

        out.close();
    }

    static class UnionFind {
        public int[] ids;
        public int[] sz;
        public int n;

        public UnionFind(int n) {
            this.n = n;
            ids = new int[n+1];
            sz = new int[n+1];
            for (int i=0;i<=n;i++) {
                ids[i] = i;
                sz[i] = 1;
            }
        }

        public void union(int p, int q) {
            p = root(p);
            q = root(q);
            if (sz[p] <= sz[q]){
                ids[p] = q;
                sz[q] += sz[p];
            }
            else{
                ids[q] = p;
                sz[p] += sz[q];
            }
        }

        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }

        public int root(int x) {
            while (x != ids[x]) {
                ids[x] = ids[ids[x]];
                x = ids[x];
            }
            return x;
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