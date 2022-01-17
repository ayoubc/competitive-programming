
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

        int c = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] C = new int[n];
        for (int i=0;i<n;i++) C[i] = in.nextInt();

        int[] d = new int[m];
        for (int i=0;i<m;i++) d[i] = in.nextInt();

        int[] p = new int[n];

        long[] ans = new long[m];

        if (n > 0) {
            for (int i=0;i<n;i++) {
                int k = 0;
                while ((1L << k) * (1L * C[i]) <= c) k++;

                p[i] = k;
            }

            int P = 0;
            for (int i=0;i<n;i++) P = Math.max(P, p[i]);

            long[] cnt = new long[n];
            for (int i=0;i<n; i++) cnt[i] = 1L;

            long[] days = new long[51];

            for (int i=0;i<P;i++) {
                for (int j=0;j<n;j++) {
                    if (p[j] <= i) cnt[j] *= 2;
                }

                for (int j=0;j<n;j++){
                    days[i] += cnt[j];
                }
            }

            for (int i=P;i<51;i++) days[i] = days[i-1] * 2;
            for (int i=0;i<m;i++) ans[i] = days[d[i]];
        }


        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++) sb.append(ans[i] + "\n");
        out.print(sb);
        out.close();
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
    }
}