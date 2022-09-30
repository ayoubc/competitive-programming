import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static long dp;
    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        long[] w = new long[n];
        P[] ps = new P[m];
        for (int i=0;i<n;i++) w[i] = in.nextLong() * -1;
        for (int i=0;i<m;i++) {
            ps[i] = new P(in.nextInt(), in.nextLong());
        }

        Arrays.sort(w);
        for (int i=0;i<n;i++) w[i] *= -1;

        long[] pre = new long[n];
        for (int i=0;i<n;i++) {
            if(i ==0 ) pre[i] = w[i];
            else pre[i] = pre[i-1] + w[i];
        }

        Arrays.sort(ps, (p1,p2) -> {
            if (p1.p == p2.p) {
                if(p1.x == p2.x) return 0;
                if (p1.x > p1.x) return -1;
                return 1;
            }
            if (p1.p > p2.p) return -1;
            return 1;
        });

        int j = 0;
        long ans = 0;
        for (int i=0;i<m;i++) {
            if (j >= n) break;
            int k = Math.min(j+ps[i].x, n);
            long cnt = pre[k-1];
            if (j != 0) cnt -= pre[j-1];
            ans += cnt * ps[i].p;
            j = k;
        }
        out.println(ans);
        out.close();
    }

    static class P {
        public int x;
        public long p;
        public P(int x, long p) {
            this.x = x;
            this.p = p;
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
