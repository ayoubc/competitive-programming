import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static int MAX = 10001;
    static int OO = (int)1e7;
    static int[][] dp;
    static int n;
    static int[] w;
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        w = new int[n+1];
        for (int i=1;i<=n;i++) w[i] = in.nextInt();

        dp = new int[n+1][MAX];
        for (int i=0;i<=n;i++) for (int j=0;j<MAX;j++) dp[i][j] = -1;

        out.println(solve(2, 1));
        out.close();
    }

    static int solve(int i, int step) {
        if (i<=0 || i > n || step >= MAX) return OO;
        if (i == n) return w[n];
        if (dp[i][step] != -1) return dp[i][step];

        dp[i][step] = w[i] + Math.min(solve(i-step, step), solve(i+step+1, step+1));
        return dp[i][step];
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
