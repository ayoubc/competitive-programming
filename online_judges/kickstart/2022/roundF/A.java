import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

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
        for(int tt=1;tt<=t;tt++) {
            int n = in.nextInt();
            F[] fs = new F[n];
            for (int i=0;i<n;i++) {
                fs[i] = new F(in.next(), in.nextInt(), in.nextInt());
            }

            F[] fscopy1 = Arrays.copyOf(fs, n);
            F[] fscopy2 = Arrays.copyOf(fs, n);

            Arrays.sort(fscopy1, (f1, f2) -> {
                int c = f1.c.compareTo(f2.c);
                if (c == 0) {
                    c = Integer.compare(f1.u, f2.u);
                }
                return c;
            });
            Arrays.sort(fscopy2, (f1, f2) -> {
                int c = Integer.compare(f1.d, f2.d);
                if (c == 0) {
                    c = Integer.compare(f1.u, f2.u);
                }
                return c;
            });
            int ans = 0;
            for (int i=0;i<n;i++) {
                if (fscopy1[i].u == fscopy2[i].u) ans ++;
            }
            out.println("Case #" + tt + ": " + ans);
        }
        out.close();
    }
    static class F {
        String c;
        int u, d;

        public F(String c, int d, int u) {
            this.c = c;
            this.u = u;
            this.d = d;
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
