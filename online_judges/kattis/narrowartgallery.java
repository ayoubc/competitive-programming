import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static int OO = 1000000;
    static List<Integer>[] graph;

    static char[][] grid;
    static int[][] rooms;
    static int[][][] dp;
    static int n;
    static int k;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            n = in.nextInt();
            k = in.nextInt();
            if (n == 0) break;

            rooms = new int[n][2];
            dp = new int[n][2][k+1];
            for (int i=0;i<n;i++) {
                for (int j=0;j<2;j++) {
                    for (int kk=0;kk<=k;kk++) dp[i][j][kk] = -1;
                }
            }

            int total = 0;
            for (int i=0;i<n;i++) {
                rooms[i][0] = in.nextInt();
                rooms[i][1] = in.nextInt();
                total += rooms[i][0] + rooms[i][1];
            }

            int ans = solve(0, k);
            out.println(total - ans);


        }
        out.close();
    }
    static int solve(int i, int k) {
        return Math.min(f(i, 0, k), f(i, 1, k));
    }
    static int f(int i, int j, int k) {
        if (k == 0) return 0;
        if (i>=n) return OO;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        int ans = rooms[i][j] + f(i+1, j, k-1);
        ans = Math.min(ans, f(i+1,  j, k));
        ans = Math.min(ans, f(i+1,  j ^ 1, k));

        dp[i][j][k] = ans;
        return dp[i][j][k];
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
