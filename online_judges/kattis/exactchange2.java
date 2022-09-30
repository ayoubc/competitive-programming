import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static int OO = (int)1e9;
    static int MAX = 10002;
    static int N = 101;
    static int[][] dp = new int[MAX][N];
    static int[] coins;
    static int[][] T;
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
        for (int tt=0;tt<t;tt++) {
            int price = in.nextInt();
            n = in.nextInt();
            coins = new int[n];
            for (int i=0;i<n;i++) coins[i] = in.nextInt();
            for (int i=0;i<MAX; i++) for (int j=0;j<N;j++) dp[i][j] = -1;

            int minPrice = solve(price, 0, 0);
            T = new int[minPrice+1][n];

            for (int i=1;i<=minPrice;i++) for (int j=0;j<n;j++) T[i][j] = -1;

            out.println(minPrice + " " + minCoins(minPrice, 0));
        }
        out.close();
    }
    static int solve(int p, int s, int i) {
        if (p <= 0) return s;
        if (i >= n) return OO;

        if (dp[p][i] != -1) return dp[p][i];

        dp[p][i] = Math.min(solve(p, s, i+1), solve(p-coins[i], s+coins[i], i+1));
        return dp[p][i];
    }

    static int minCoins(int p, int j) {
        if (p == 0) return 0;

        if (p < 0 || j >= n) return OO;

        if (T[p][j] != -1) return T[p][j];

        T[p][j] = Math.min(minCoins(p, j+1), 1 + minCoins(p-coins[j], j+1));
        return T[p][j];
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
